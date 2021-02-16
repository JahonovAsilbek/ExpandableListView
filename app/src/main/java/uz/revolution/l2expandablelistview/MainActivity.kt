package uz.revolution.l2expandablelistview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import uz.revolution.l2expandablelistview.adapters.ExpandableAdapter
import uz.revolution.l2expandablelistview.models.MyModel

class MainActivity : AppCompatActivity() {

    lateinit var map: HashMap<String, ArrayList<MyModel>>
    lateinit var titleList: ArrayList<String>
    lateinit var list:ArrayList<MyModel>
    lateinit var adapter: ExpandableAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
        adapter = ExpandableAdapter(titleList, map)
        expandable_list_view.setAdapter(adapter)

        adapter.setOnChildItemClickListener(object : ExpandableAdapter.OnChildItemClickListener{
            override fun onClick(image: Int) {
                var intent = Intent(this@MainActivity, InfoActivity::class.java)
                    intent.putExtra("image", image)
                Log.d("AAAA", "onClick: ${image}")

                startActivity(intent)
            }

        })

    }

    private fun loadData() {
        map = HashMap()
        var fruitList = ArrayList<MyModel>()

        fruitList.add(MyModel("Apple", R.drawable.apple))
        fruitList.add(MyModel("Mango", R.drawable.mango))
        fruitList.add(MyModel("Banana", R.drawable.banana))
        fruitList.add(MyModel("Orange", R.drawable.orange))
        map.put("Fruits", fruitList)

        val flowerList = ArrayList<MyModel>()

        flowerList.add(MyModel("Rose", R.drawable.rose))
        flowerList.add(MyModel("Tulip", R.drawable.tulip))
        flowerList.add(MyModel("Daffodi", R.drawable.daffodi))
        flowerList.add(MyModel("Cherry Blossom", R.drawable.cherryblossom))
        flowerList.add(MyModel("Daisy", R.drawable.daisy))
        flowerList.add(MyModel("Lily", R.drawable.lily))
        map.put("Flowers",flowerList)

        val animalList = ArrayList<MyModel>()

        animalList.add(MyModel("Lion", R.drawable.lion))
        animalList.add(MyModel("Monkey", R.drawable.monkey))
        animalList.add(MyModel("Cat", R.drawable.cat))
        animalList.add(MyModel("Dog", R.drawable.dog))
        map.put("Animals", animalList)

        val birdList = ArrayList<MyModel>()

        birdList.add(MyModel("Crow",R.drawable.crow))
        birdList.add(MyModel("Peacock",R.drawable.peacock))
        birdList.add(MyModel("Dove",R.drawable.dove))
        birdList.add(MyModel("Parrot", R.drawable.parrot))
        map.put("Birds",birdList)


//        val fruits = arrayListOf("Apple", "Mango", "Banana", "Orange")
//        map["Fruits"] = fruits
//
//        val flower =
//            arrayListOf("Rose", "Lily", "Tulip", "Daffodi", "Cherry Blossom", "Daisy")
//        map["Flowers"] = flower
//
//        val animals = arrayListOf("Lion", "Monkey", "Cat", "Dog",)
//        map["Animals"] = animals
//
//        val birds = arrayListOf("Crow", "Peacock", "Dove", "Goose", "Barn owl", "Parrot")
//        map["Birds"] = birds

        titleList = ArrayList()
        titleList.add("Fruits")
        titleList.add("Flowers")
        titleList.add("Animals")
        titleList.add("Birds")

    }

}