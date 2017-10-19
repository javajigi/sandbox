#!/bin/bash

current_dir=$(pwd)
echo "current dir : $current_dir"

workspace=~/codesquad/review-workspace

function clone_repository {
  if [ ! -d "$1" ]; then
    echo "clone $1 repository"
    git clone https://github.com/code-squad/$1.git
  fi
}

function add_remote_pull {
  git config --add remote.origin.fetch "+refs/pull/*/head:refs/remotes/origin/pr/*"
}

function fetch {
  git fetch origin
}

if [ "$1" ]; then
  cd $workspace
  clone_repository $1
  cd $1
  git fetch origin
  cd ..
  echo "$1 repository clone & fetch"
  exit
fi

while read project_id; do
  cd $workspace
  clone_repository $project_id
  cd $project_id
  git config --add remote.origin.fetch "+refs/pull/*/head:refs/remotes/origin/pr/*"
  git fetch origin
  cd ..
done < $current_dir/projects.txt