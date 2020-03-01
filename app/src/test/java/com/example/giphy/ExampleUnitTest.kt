package com.example.giphy

import com.example.giphy.data.model.SearchResponse
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        var test = HashSet<String>()
        test.add("1")
        test.add("2")
        test.add("3")
        test.add("3")
        test.add("4")
        test.remove("3")

        if(test.contains("3")){
            print("gg")
        }


        println(test.toString().replace("]","").replace("[",""))
        print(test.toString().substring(1,test.toString().length-1))



    }


}
