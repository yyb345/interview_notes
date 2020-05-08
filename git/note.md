本文用来记录git一些相关的操作



##  最基本的概念

远程仓库：一般用origin来代表

本地仓库：



## 1. 推和拉

push: git push origin [本地分支名]:远程分支名称，如果已经在本地分支了，则可以用head来代替，git push origin head:远程分支名

关联远程分支的目的是说，在git pull的时候，直接从对应的远程分支拉到本地分支了

关联远程分支的命令：git branch --set-upstream-to origin/[远程分支名]

Pull:



## 2. 分支如何演变

