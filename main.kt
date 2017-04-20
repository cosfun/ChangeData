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
    val s=magic(list,Data2Info::class.java)
    println(s.size)
}
fun <T:Any> magic(infoList: ArrayList<T>,model:Class<*>,magicType:Int=-1):ArrayList<Any>{
    var count=magicType
    count++
    val anser=ArrayList<Any>()
    if(0==infoList.size)
        return anser
    magicData<T> {
        this.magicType=count
        saveData=anser
        Nod_Y_Lle_Delfrydol{
            this initData infoList
        }
        Le_Cheile_Beidh_Muid{
            this initData model
        }
    }
    return anser
}
