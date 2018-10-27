package a3cv6.escom.ipn.mx.login

import java.security.MessageDigest

/*****************************************************
 *  S I N G L E T O N   D E S I G N   P A T T E R N  *
 *****************************************************/
class User private constructor(){

    init{}
    private object Holder { val INSTANCE = User() }

    companion object {
        val instance: User by lazy { Holder.INSTANCE }
    }

    // Instance Attributes
    var name:String? = null
    var token:String? = null
    //var loggedIn:Boolean = false
}

/* ----------------- JAVA IMPLEMENTATION -----------------------

    public class LazyInitializedSingleton {

        private static LazyInitializedSingleton instance;
        private LazyInitializedSingleton(){}

        public static LazyInitializedSingleton getInstance(){
            if(instance == null)
                instance = new LazyInitializedSingleton();
            return instance;
        }
    }
*/

/*****************************************************
 *  E X T E N D I N G  C L A S S  F U N C T I O N S  *
 *****************************************************/
private fun String.hashWithAlgorithm(algorithm: String): String {
    val digest = MessageDigest.getInstance(algorithm)
    val bytes = digest.digest(this.toByteArray(Charsets.UTF_8))
    return bytes.fold("", { str, it -> str + "%02x".format(it) })
}

fun String.sha512(): String {
    return this.hashWithAlgorithm("SHA-512")
}