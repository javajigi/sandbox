#!/bin/bash

WORKSPACE=~/codesquad/workspace
cd $WORKSPACE

project_name=java-racingcar
if [ ! -d "$project_name" ]; then
  git clone https://github.com/code-squad/$project_name.git
fi

cd $project_name
git fetch --prune

function exist_remote_branch {
  remote_branch_name=$(git branch -r | grep origin/$1)
  echo $remote_branch_name 
}

function create_branch {
  branch_name=$(exist_remote_branch $1)
  echo "branch name : $branch_name"
  if [ ! "$branch_name" ]; then
    echo "create local branch"
    git checkout -b $1 origin/master

    echo "push branch"
    git push --set-upstream origin $1
  fi
}

create_branch sanjigi

