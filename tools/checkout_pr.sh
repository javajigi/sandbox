#!/bin/bash

current_dir=$(pwd)
echo "current dir : $current_dir"

workspace=~/codesquad/review-workspace

reg="https://github.com/code-squad/(.*)/pull/(.*)"

function clone_repository {
  cd $workspace

  directory=$1-$2
  if [ ! -d "$directory" ]; then
    echo "clone $directory repository"
    git clone https://github.com/code-squad/$1.git $directory
  fi
}

# function checkout_branch {
#   cd $workspace/$1-$2
#   echo "current dir : $(pwd)"

#   branch_name=$(git branch -l | grep $1)
#   echo "branch name : $branch_name"
#   if [ ! "$branch_name" ]; then
#     git checkout -t origin/$1
#   fi
# }

function fetch_reset {
  git fetch origin pull/$1/head:pull_$1
  git checkout pull_$1
  git branch -a
}

if [ ! "$1" ]; then
  echo "sync할 url 경로를 입력하세요"
  exit
fi

if [[ $1 =~ $reg ]]
then
  echo "id ${BASH_REMATCH[1]}, name ${BASH_REMATCH[2]}"
  clone_repository ${BASH_REMATCH[1]} ${BASH_REMATCH[2]}
  cd $workspace/${BASH_REMATCH[1]}-${BASH_REMATCH[2]}
  fetch_reset ${BASH_REMATCH[2]}
else
  echo "does'not match"
fi