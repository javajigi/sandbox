#!/bin/bash

current_dir=$(pwd)
echo "current dir : $current_dir"

workspace=~/codesquad/review-workspace

reg="https://github.com/(.*)/(.*)/commit/(.*)"

function clone_repository {
  cd $workspace

  directory=$2-$1
  if [ ! -d "$directory" ]; then
    echo "clone $directory repository"
    git clone https://github.com/$1/$2.git $directory
  fi
}

function checkout_branch {
  cd $workspace/$2-$1
  echo "current dir : $(pwd)"

  branch_name=$(git branch -l | grep $1)
  echo "branch name : $branch_name"
  if [ ! "$branch_name" ]; then
    git checkout -t origin/$1
  fi
}

function fetch_reset {
  git fetch origin $1
  git reset --hard FETCH_HEAD
}

if [ ! "$1" ]; then
  echo "sync할 url 경로를 입력하세요"
  exit
fi

if [[ $1 =~ $reg ]]
then
  echo "id ${BASH_REMATCH[1]}, name ${BASH_REMATCH[2]}, commit id : ${BASH_REMATCH[3]}"
  clone_repository ${BASH_REMATCH[1]} ${BASH_REMATCH[2]}
  checkout_branch ${BASH_REMATCH[1]} ${BASH_REMATCH[2]}
  fetch_reset ${BASH_REMATCH[3]}
else
  echo "does'not match"
fi