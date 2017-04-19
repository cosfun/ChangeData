import kotlin.reflect.full.memberProperties
import sun.reflect.misc.ConstructorUtil.getConstructors
import java.io.Serializable
import java.lang.reflect.Method
import kotlin.reflect.full.createInstance
import kotlin.reflect.jvm.jvmName


/**
 * Created by Administrator on 2017/4/19.
 */
fun main(args: Array<String>){

    val d:Data1Info=Data1Info()
    d.id="3"
    d.name="class"
    val c=Data1Info.Good()
    c.grade="99"
    c.id="0"
    c.name="wang"
    d.list.add(c)
    val f=Data1Info.Good()
    f.id="2"
    f.name="zheng"
    f.grade="100"
    d.list.add(f)
    println("test")
    val list=ArrayList<Data1Info>()
    list.add(d)
    changeData(list,Data2Info::class.java)
    /*val mc = d::class.java
    val shili=mc.newInstance()
    for(i in mc.declaredMethods){
        if(i.name.startsWith("set"))
            println(i.name)
    }
    val m2 = mc.getMethod("getId")
    println(m2.invoke(d))
    // 查看每个构造方法需要的参数
    //val id=mc.declaredFields[0]
    val modec=Data2Info::class.java
    //val method=modec.getMethod("setId",)*/
}
fun <T:Serializable> changeData(infoList: ArrayList<T>,model:Class<*>) {
    val anser=ArrayList<Any>()
    val samClass=infoList[0]::class.java
    val innerName=samClass.declaredClasses[0].name
    val methosName=ArrayList<String>()
    val methosParmsType=ArrayList<Class<*>>()
    val methosValues=ArrayList<String>()
    println(samClass.declaredClasses[0].name)
    for(i in samClass.declaredMethods){
        for(j in i.genericParameterTypes){
            if(i.name.startsWith("set")&&!j.typeName.toString().contains(innerName)){
                methosName.add(i.name)
                methosParmsType.add(i.parameterTypes[0].name.javaClass)
                println(i.parameterTypes[0].name.javaClass)
            }
        }
    }
    infoList.forEach {
        val newModel=model.newInstance()
        methosName.forEachIndexed { index, s ->
            val method=model.getMethod(s,methosParmsType[index]).invoke(newModel,"3")
        }
        anser.add(newModel)
    }
    println("over")
}
fun <T:Serializable> changeData(info: T,model:Class<*>){
    val mc = info::class.java
    for(i in mc.declaredClasses){
            println(i.name)
    }
    println("TEST------------------")
    /*for(i in mc.declaredMethods){
        if(i.name.startsWith("set"))
            println(i.name)
    }*/
    val new=model.newInstance()
   val modec=model.getMethod("setId",mc.getMethod("getId").genericReturnType.typeName.javaClass)
    modec.invoke(new,"34")
    println(new)
}