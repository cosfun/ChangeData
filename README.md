# ChangeData
学习github的使用
 
这里是kotlin代码将多级数据转换成平级
例如

`
{
   a=3
   b=1
   {
     c=1
     d=1
   }
   {
     c=2
     d=3
   }
}
`

转换后

`{ {a=3 b=1 d=0 c=0}{a=0 b=0 c=1 d=1 } {a=0 b=0 c=2 d=3 } }`

