# 前端学习笔记

 

## 前言

 

为什么需要前端学习：需要搭建一个完整的流程工具系统，而组内前端资源比较匮乏，因此前端的学习是必须的，这是最基本的能力与水平，那么需要掌握到什么程度呢？可以满足产品开发的水平，至少是及格分吧，可以一边结合工作进行学习，如果正常进行系统的学习，应该是没有问题的。可以一边工作一边思考一边实践结合的进行学习。

总的来说，需要学习这三个基本的方面。

 

## 第一章： 总体概述与概览

 

HTML 定义了网页的内容

CSS  定义了网页的布局

JavaScript 定义了网页的行为 

 

 

## 第二章  HTML 学习指南

https://www.w3school.com.cn/tags/tag_input.asp

 

标签学习、记忆为主，根据理解去记忆

<p> 是个段落

<span> 组合行内元素

<tr> 表格中的行

<td> 表格中的单元格

target="_blank" 在新的标签窗口中打开页面

 

 

 

## 第三章 CSS 学习指南

 

1. 为了解决网页内容与展示分离，方便分离

2. 基本语法：选择器 一条或多条声明

 

.P

{

  Color: red;

  Text-align: center;

}

 

选择器可以为id选择器或者class选择器,一般为class选择器

.号为前缀

 

\3.   有哪几种选择：外部样式表、内部样式表和内联样式表

它们之间有继承优先级关系的，具体到时候可以查。

\4.   

 

 

样式如何调整？

 



## 第四章 JavaScript学习指南

https://www.w3school.com.cn/js/js_obj_array.asp

JavaScript 需要学习如何与后端进行交互

1. 是一种动态脚本语言

2. Ajax 请求，页面异步地向服务端发出请求，然后拿到结果，进而渲染页面

3. 可以插入到html 中去

4. 几个关键字： 事件、函数 一般这两个结合来使用

5. 除了可以动态加载内容外，也可以动态改变html 的样式

 

常见的几个事件： OnClick、 OnMouseOver 、 OnLoad

函数定义规则 : function functionname(){

  //代码

}  //一般定义在<script>标签中去

 

下一步学习js如何写代码？

前期建议编码原则：先把业务伪代码写出来，然后再把语法写出来

目标：写一个半成品出来，个人简历信息页面用js写出来

目的：熟悉网页调试功能、常见的开发流程

 

## 第五章  渲染引擎学习指南

 

Velocity: https://www.jianshu.com/p/5913903324ff

https://blog.csdn.net/nengyu/article/details/6671904

 

 

1. 是一种模块渲染引擎，前后端分离的展现层

2. 它是一个容器，后端代码往容器里写数据，前端用特定的语法取数据并展示

3. $表明变量，每个编程动作开头都加#

4. 渲染引擎或者模版里面 配合html标签，进行展示

 Html https://www.w3school.com.cn/tags/tag_div.asp

5. Div 标签是一个块级标签

6. Span 行内元素

7. 渲染引擎配合angular进行编程

8. 渲染引擎也可以配合js进行编程

9. 需要了解各种html标签，比如表单， $nbsp等 

 把scrence.vm前端标签全部学习一遍，理解透彻些～

 

 

Javascipt 与 angular 有什么关系和区别？

 

 

## 第六章 AngularJS学习

https://www.runoob.com/angularjs/angularjs-scopes.html

https://www.w3cschool.cn/angularjs/

1. Anglular 绑定数据与展示的关系，也就是说数据改变，展示立马就会更新。通常与外部的js一起使用

 

2. \$scope是一个作用域对象，包含属性与方法，html与js的纽带，html直接使用其属性，不用$scope属性

 

3. ng-init 初始化应用程序数据

4. ele.select2 是什么意思？

 

Mustache语法

 

第七章 

 

 