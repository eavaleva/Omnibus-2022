# APDE-2122-group-7

## Developing on the project

In order to be able to work on this project you'll need to have cloned this project to your local machine.
We've decided to divide changes into separate features, so when working on a change, please use the following format for branches that have:

- Major feature specific changes. `feature/<your-branch-name>`
- Unrelated changes, not specific to any feature. `boyscout/<your-branch-name>`

Always try to create your branches from the latest changes on the main branch, this can be accomplished by checking out the main branch on your
local repository and pulling the remote main branch. After that point you can create a new branch based on the main branch, with the latest changes.

When you've made some changes, and you're ready to make commits, try to group your changes per commit. Remember, a feature/ pull request can
consist of multiple commits, and is not limited by one commit.

Also, before making a pushing your changes tom your remote branch, make sure to include the latest changes of the main branch. You can check if that is
necessary by fetching all remotes, if there are changes made, this will be visible in the tree graph of your git client, and then you'll have to:

1. Check out to your local main branch
2. Pull the remote main branch to your local repository
3. Check out your branch, with your changes
4. Merge the main branch with the branch with your changes

After that you can push your changes to your remote branch and if you want to create a pull request, when your feature is complete and ready for review

Pull requests are necessary to merge your branch, with the changes you made, with the main branch. When you make a Pull request try to give a short
description of the changes that you've made, and assign yourself, and if possible the issue that you've picked up for those changes, to the pull request.
Also request at least 1, or all teammates, for a review on your pull request. At least 1 review approval is mandatory to be able to merge the pull request.

After you've made the optional request changes, and have been given the approval to merge your branch, you can merge the branch to main. The branch will
be automatically removed from the remote repository, and you can now also checkout and pull the main branch locally, and remove your old branch to prevent
confusion. Now you're also immediately ready and set up to start a new branch for even more changes.
