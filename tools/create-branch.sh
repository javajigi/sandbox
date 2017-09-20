#!/bin/bash

current_dir=$(pwd)
echo "current dir : $current_dir"

workspace=~/codesquad/workspace

function clone_repository {
  cd $workspace

  if [ ! -d "$1" ]; then
    git clone https://github.com/code-squad/$1.git
  fi
}

function sync_branch {
  echo "sync $1 from remote to local"
  cd $workspace/$1
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

function create_branches {
  while read github_id; do    
      create_branch $github_id   
  done < $current_dir/$1.txt
}

while read project_id; do
  clone_repository $project_id
  sync_branch $project_id
  create_branches $project_id
done < $current_dir/projects.txt
