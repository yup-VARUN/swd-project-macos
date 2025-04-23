This version is a build for MacOS Users(I have MacBook Pro with M2 Pro) with detailed setup instructions:

Here's an actually good documentation:
<hr>
<hr>
You can skip this part if you know git & github:

#### A Clarity that you must have before we start is that
```
git ≠ GitHub
```
- **Git** is a piece of code that lives in your computer locally, it observes every single thing happening in a repository(if you enable git to track them).
- **GitHub** is the real cloud platform for then collaborating with other people also using git...

### Git & GitHub

See, you will mostly work on your cloned version(locally copied version).
1. Say you made a bunch of changes, wrote a bunch of code.
2. Now your clone is ahead of the other two copies
How would you push these changes/updates to there?
It's done in the reverse order that you copied
meaning, changes move like this:
```
Original GitHub Repo <- Fork <- Clone
```
Let's understand these 2 different steps real quick:

**__Step 1:__** Fork <- Clone
- To do this you first stage your changes.
`git add <filename(s)>`
- These filtered/selective changes are then committed in a branch(just ignore the term branch for like the first 2-3weeks of using github to make your life easier)
`git commit -m"commit message-just to record what is in this change"`
- Lastly:
`git push`

**__Step 2:__** Repo <- Fork
- To do this you need to go to your forked repository, you'll see a button called `contribute`.

That's how you request the owner of the original repository to see and merge your changes into their repository

**SO, GO AHEAD AND FORK THIS REPOSITORY TO START YOUR SOFTWARE DEVELOPMENT JOURNEY!**
<hr>
<hr>

<br>
<br>
<br>
<br>
<br>


<i>VERY IMPORTANT READ IF YOU'RE NEW TO: **SQL** or **JAVA** or **MAVEN**:</i>

# Maven & SQL Setup Instructions
### 1.1 MySQL Setup:
  1. **__Installing__**<br>
  - Make sure you've installed the MySQL for MacOS(getting brew installed MySQL is often is pain in the butt - no joke!).
  - If you're installing **MAKE SURE** to save the username and password! People literally forget and then reinstall the whole thing!<br>
  - If you installed the app from the official website then here's how it should look:
  ![sql view](/Static/sql_settings.png) 


  2. **__Running MySQL in terminal__**<br>
  Run `mysql -u root -p` command in your terminal to run MySQL. As simple as that.

  - <u>**However</u>\*: Adding `mysql` command to PATH**<br>
  It automatically doesn't gets added to the terminal's PATH, so you'll see an error:<br>
  `zsh: command not found: mysql`<br>
    - There's an environment file(called `!/.zshrc`)
    - Your terminal uses it to refer(like a dictionary) for everything. 
    - Your goal is to append a simple line:
    
    ```
    export PATH=$PATH:/usr/local/mysql/bin
    ```

      - Either just open it in VS Code using: `code !/.zshrc` then write the export line and save it. 
      BTW -> for using `code` command your VSCode should have it enabled.
        - I'd recommend you to do so because it makes life so much easier(like you can just cd to your folder u wanna open in VS Code, and just type `code .`)
      - OR use nano editor by executing: `nano ~/.zshrc` and save and exit

  - Now refresh your terminal: by running: `source ~/.zshrc`

  3. **Create a `test_database`(later used for testing JBDC Connection):**
  - Here's a snapshot from my terminal:
  ```
  ➜  ~ mysql -u root -p
  Enter password: 
  ```
  Here you'll not be able to see what you type, but just type your pass and hit enter.
  ```
  Welcome to the MySQL monitor.  Commands end with ; or \g.
  Your MySQL connection id is 10
  Server version: 9.2.0 MySQL Community Server - GPL

  Copyright (c) 2000, 2025, Oracle and/or its affiliates.

  Oracle is a registered trademark of Oracle Corporation and/or its
  affiliates. Other names may be trademarks of their respective
  owners.

  Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.
  ```
  <u>**LAST STEP:**</u> 

  Now you'll be able to interact with mysql interpreter from the terminal, create a test database(I've literally called it `test_database` lol):
  ```
  mysql> create Database test_database
      -> ;
  Query OK, 1 row affected (0.01 sec)

  mysql> 
  ```

### 2. Understanding Maven:
Install **Maven for java** extension from the extension store in VS Code. And there's a few more required & recommended extensions: Java, and Extension Pack for Java (by microsoft).

Now you need to stop procrastinating and understand industry standard practices(<i>ik it's very painful for the first time</i>). There's three aspects you need to learn:
1. What folder heirarchy to organize stuff into.
    - this setup tutorial is the only one you need(I promise): [Youtube Video](https://www.youtube.com/watch?v=ArW93visVhc)
2. The features it unlocks.
    - Continuous Testing, 
    - Development Environments, 
    - Package Management, 
    - **Build** Tools(configured from a file called `pom.xml`)<br>
      **<u>Note:</u>** 
      ```
      Term "build" is yet another buzzword in the world of C.S.
      
      It just means compiling your whole project(spreaded across multiple files) into machine code(for your particular CPU) that your operating system can then execute!

      There is a lot of  "setup"  needed to pull something like this off. Ability to do this generalizably across different CPU architectures, configurations, ... is the impressive engineering side of things(you can chatGPT about it to learn more).
      ```
3. How to Open/Create Projects:\*\*
    - Opening projects is non-trivial(YES)!
      - For your VS Code's extension to actually recogonize your java project and install required things in the background(and more) you need to open it in a very particular way:
      - Press: SHIFT + CMD + P
      - Write Java:
      ![open_java_project](/Static/opening_projects.png)
      - Click on `Java: Open Project`<br>
      (in my ss I've already opened one so I can't see the Open Projects Option)
      - If you can't open a project from 'Java', then try searching `Maven: Open Project` instead.
4. To run a project: in any .java file just right click and you'll see an option `run java`. Click it.

### 3. Getting `MySQLConnectionExample.java` file to run:
1. Updating your database details in the code:
    - In this java file, update the database name according to whatever you've created.
    - <b>.env file:</b><br>
    In your env file make sure you have the corresponding username and database password:<br>
    ![.env file contents:](/Static/image.png)
    - .gitignore file is a list of items that you don't want 'Git' to track and put on GitHub for the rest of the world to see. We hide all important environment variables here so that no one else can see them.

Once you're able to run this, you are now set up to run your first build test! Just click on the **green tick button** in front of the 16th line(as shown):<br>
![test run/build](/Static/image2.png)

You should see:<br>
![alt text](/Static/build_results.png)


### 4. Running the actual project:
1. Create the dummy database and populate it:
    - Run SQL queries available in the [table creation file](table_creation_script.sql).
    ![running sql commands to create dummy database](/Static/database.png)
    - Run SQL queries in the [table population file](table_poplation_script.sql).
    ![populate](/Static/populate.png)
2. 

<br>
<br>

# GitHub Contribution Instructions:
Try not to ever change someone else's written code! 

If you find yourself in that situation:
1. The code didn't follow SOLIDS Principle.
2. You should always be able to write an interface or a class that inherits from whatever functionality you want to use in your contributions.
3. However, `main.java` or `app.java` might be changed and that's fine.

**Now:**<br>
- You're probably going to create a new feature, in a new class(please create a separate file for it). 
- If you're implementing a new feature, create a feature branch using `git branch <branch_name>` and then switch your repository to that branch `git checkout <branch_name>`.
- Now this is like a parallel world where anything you do won't affect the real world(main branch).

**Ready with a contribution?**<br>
How-To: You'll find yourself in either of the two situations:
1. If your collaborator is experienced in moderating GitHub contributions then you can directly create a pull request in a way where:

> ```
> OG repository on GitHub <-  (create PR) Your fork on GitHub  <- (Push) the Feature branch's commit
> ```
- This allows for the moderator to review anything and everything that goes into the main branch. 
- This can also trigger GitHub workflows(CI/CD) if you've set them up. It'll make sure that any state of the code that tries to go into the main first passes all the build checks and custom defined tests.

2. If you're instead working with a beginner moderator who doesn't want to review or can't review:
- Others might've done contributions in the meanwhile. Sync your fork(to bring in the latest version of the OG GitHub repo that you forked to begin with) and run `git checkout main` and then run `git pull` command to bring in the new changes in your cloned(downloaded) version of the repository. (this will make the moderator's life easier)
- Finally, merge your feature branch

> Once you and your partner get used to git and github, never do the 2nd method!<br>
> - **This is enough to get you fired in a company!**<br>
❌ Don’t merge the feature branch into main locally and then push it — this bypasses review and CI checks.
❌ Avoid pushing anything directly to the main.

### Last Step:
You'll have to truly, fully understand what a commit really means and then learn about Rebase, Merge, Squash, and Stash.
