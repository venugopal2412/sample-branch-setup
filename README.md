# Git Branching Strategy
This repository follows a Git Flow branching strategy to ensure a structured and efficient development process. The goal is to keep the main codebase stable, facilitate collaboration, and streamline releases. Below is a detailed description of each branch type used in the repository.

# Branch Types
# 1. Main or Master Branch (main or master)
# Purpose: This is the default and stable branch, typically used for production-ready code.
# When to Commit: Only commit to this branch when a feature is complete, tested, and ready for release.
# Best Practices:
Ensure that code in the main branch is always deployable and bug-free.
Code in this branch should pass all tests and have been reviewed.
2. Feature Branches (feature/<feature-name>)
Purpose: These branches are used for developing new features or significant updates.
When to Create: Create a new branch from main when starting a new feature.
# Examples:
feature/user-authentication for building user login functionality.
feature/profile-page for working on the user profile page.
# Best Practices:
Keep each feature branch focused on a single feature or update.
Frequently merge the latest changes from the main branch into the feature branch to avoid conflicts.
Once a feature is complete, it should be merged back into develop (or main, depending on your process).
# 3. Bug Fix Branches (bugfix/<issue-name> or hotfix/<issue-name>)
# Purpose: These branches are used for fixing specific bugs that may need to be addressed quickly or in isolation.
# When to Create: Create a new branch from main or the relevant branch when working on a bug fix.
# Examples:
bugfix/fix-login-issue for fixing a problem with the login screen.
hotfix/crash-on-launch for urgent issues that need to be fixed immediately.
# Best Practices:
Once the bug is fixed, merge the branch back into main and close the related issue.
For urgent fixes (hotfixes), also merge the changes into develop to ensure that the fix is present in the next release.
# 4. Experiment/R&D Branches (experiment/<experiment-name>)
# Purpose: These branches are used for trying out new ideas or experimental features that may not be implemented in the final product.
# When to Create: Create this branch if you are unsure about an approach or want to test something that might not be adopted in the final version.
# Examples:
experiment/try-new-layout for experimenting with a new layout for the main screen.
experiment/test-new-database for testing a new database technology.
# Best Practices:
Once the experiment is concluded, either discard the branch if the experiment fails or merge it into a feature branch if successful.
# 5. Release Branches (release/<release-version>)
# Purpose: These branches are used for preparing a specific version of the app for release.
# When to Create: Create a release branch when preparing for a new version. This is a stable branch where final testing, documentation, and bug fixes occur.
# Examples:
release/1.0.0 for preparing the first public version.
# Best Practices:
Use this branch to finalize the app before deployment.
Any critical fixes should be made here and merged into both main and develop.
# 6. Development Branch (develop)
# Purpose: Used as the integration branch for features and bug fixes before they are merged into the main branch.
# When to Create: The develop branch is often used as the default branch to commit feature work that is not yet production-ready.
# Best Practices:
Pull requests (PRs) are merged into develop first.
Once everything is stable and tested, the develop branch is merged into main for release.
Ensure that all feature work is tested and approved before merging into develop.



