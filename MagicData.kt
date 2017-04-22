/**
 * Created by Administrator on 2017/4/20.
 */
class MagicData<T:Any> {
    var samClass:Class<out T>?=null
    var saveData:ArrayList<Any>?=null
    var innerName=""
    var haveClass=false
    var methosName=ArrayList<String>()
    var methosParmsType=ArrayList<Class<*>>()
    var methosClass=""
    var infoList: ArrayList<T>?=null
    var model:Class<*>?=null
    var magicType=-1
    fun Le_Cheile_Beidh_Muid(block:MagicData<T>.()->Unit){
        block()
        infoList?.forEach {
            val newModel=model!!.newInstance()
            methosName.forEachIndexed { index, s ->
                model!!.getMethod(s,methosParmsType[index]).invoke(newModel,samClass?.getMethod(s.replace("set","get"))?.invoke(it))
            }
            saveData?.add(newModel)
            if(haveClass) {
                val me=samClass?.getMethod(methosClass)?.invoke(it) as ArrayList<Any>
                if (me.size>0){
                    saveData?.addAll(magic(me,model!!,magicType))
                }
            }
        }
    }

    infix fun initData(model:Class<*>){
        this.model=model
    }
    fun Pwysig_Iw_Pentyrru(){
        for(i in samClass!!.declaredMethods){
            for(j in i.genericParameterTypes){
                // println("j="+j.toString()+",innerName="+innerName+",return="+j.toString().contains("$"))
                // if(i.name.startsWith("set")&&!j.toString().contains(innerName)){
                if(i.name.startsWith("set")&&!j.toString().contains(innerName)){
                    methosName.add(i.name)
                    methosParmsType.add(i.parameterTypes[0])
                }
            }
            // if(i.name.startsWith("get")&&i.genericReturnType.toString().contains(innerName)){
            if(haveClass&&i.name.startsWith("get")&&i.genericReturnType.toString().contains(innerName)){
                methosClass=i.name
            }
        }
    }
    infix fun initData(data: ArrayList<T>){
        infoList=data
        samClass  =  data[0]::class.java
    }
    fun Nod_Y_Lle_Delfrydol(block:MagicData<T>.()->Unit){
        block()
        innerName=if(samClass!!.declaredClasses.size>0) samClass!!.declaredClasses!![0].name else "-1"
        haveClass=!innerName.equals("-1")
        Pwysig_Iw_Pentyrru()
    }
}
fun <T:Any> magicData(block:MagicData<T>.()->Unit):MagicData<T>{
    val new=MagicData<T>()
    block(new)
    return new
}
