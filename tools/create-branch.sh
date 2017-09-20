#!/bin/bash

current_dir=$(pwd)
echo "current dir : $current_dir"

project_name=java-racingcar
workspace=~/codesquad/workspace

function clone_repository {
  cd $workspace

  if [ ! -d "$project_name" ]; then
    git clone https://github.com/code-squad/$project_name.git
  fi
}

function sync_branch {
  cd $workspace/$project_name
  git fetch --prune
}

function create_branch {
  branch_name=$(git branch -r | grep origin/$1)
  echo "branch name : $branch_name"
  if [ ! "$branch_name" ]; then
    echo "create $1 local branch"
    git checkout -b $1 origin/master

    echo "push $1 branch"
    git push --set-upstream origin $1
  fi
}

clone_repository
sync_branch

while read github_id; do    
    create_branch $github_id   
done < $current_dir/$project_name.txt