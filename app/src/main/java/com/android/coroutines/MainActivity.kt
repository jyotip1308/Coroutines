package com.android.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.coroutines.ui.theme.CoroutinesTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

class MainActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       /* GlobalScope.launch {
            delay(3000L)
            Log.d("Main Activity" , "Coroutine says hello from thread ${Thread.currentThread().name}")
            Log.d("Main Activity2" , "Coroutine says hello from thread ${Thread.currentThread().name}")
        }

        GlobalScope.launch {
//            delay(3000L)
            Log.d("Main " , "Coroutine says hello from thread ${Thread.currentThread().name}")
            Log.d("Main " , "Coroutine says hello from thread ${Thread.currentThread().name}")
        }


        Log.d("Main Activity3" , "Hello from thread ${Thread.currentThread().name}")
        Log.d("Main Activity3" , "Hello from thread ${Thread.currentThread().name}")

        //d3
        Log.d("Main Activity3" , "Hello from thread ${Thread.currentThread().name}")
        //d4
        Log.d("Main Activity3" , "Hello from thread ${Thread.currentThread().name}")


        Log.d("MAC","tewmp")
*/



//        var a = "breask"
//        Log.d("MAC",a)


        setContent {
            CoroutinesTheme {

                    Greeting("Android",)

            }
        }


        //Suspend Function
/*        GlobalScope.launch {
            delay(3000L)
            val network = doNetworkCall()
            val network2 = doNetworkCall2()

            Log.d("Suspend", network)
            Log.d("Suspend", network2)

        }*/

     /*   GlobalScope.launch ( Dispatchers.IO ){

            Log.d("Main Activity" , "Starting coroutine from thread ${Thread.currentThread().name}")

            val network = doNetworkCall()
            withContext(Dispatchers.Main){
                
                Log.d("Main Activity" , "New thread ${Thread.currentThread().name}")

            }
        }*/



        //Run Blocking
/*        Log.d("Main Activity", "Before runBlocking")

        runBlocking {
            launch(Dispatchers.IO){
//                delay(8000L)
                Log.d("Main Activity", "Finished coroutine 1")
            }
            launch(Dispatchers.IO){
//                delay(8000L)
                Log.d("Main Activity", "Finished coroutine 2")
            }

            Log.d("Main Activity", "Start of runBlocking")
            delay(11000L)
            Log.d("Main Activity", "End of runBlocking")
        }

        Log.d("Main Activity", "After runBlocking")*/


        //Job, Waiting, Cancellation

        val job = GlobalScope.launch (Dispatchers.Default){
//            repeat(5){
//                Log.d("Main Activity", "Coroutine is still working")
//                delay(1000L)
//            }
            Log.d("Main Activity", "Starting Calculation")


            withTimeout(500L){
                for (i in 30..40){
                if (isActive){
                    Log.d("Main Activity", "Result is = $i : ${fib(i)}")
                }
            }
        }



//            for (i in 30..40){
//                    Log.d("Main Activity", "Result is = $i : ${fib(i)}")
//
//            }



//            for (i in 30..40){
//                if (isActive){
//                    Log.d("Main Activity", "Result is = $i : ${fib(i)}")
//
//                }
//            }

            Log.d("Main Activity", "Ending Calculation")


        }

//        runBlocking {
//            delay(1000L)
////            job.join()
//            job.cancel()
//            Log.d("Main Activity", "Canceled Job")
//        }

    }

    fun fib(n: Int) : Long{
        return if (n ==0) 0
        else if (n==1) 1
        else fib(n-1) + fib(n-2)
    }

/*    suspend fun doNetworkCall() : String{
        delay(3000L)
        return "Network Call"
    }*/

//    suspend fun doNetworkCall2() : String{
//        delay(3000L)
//        return "Network Call2"
//    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
