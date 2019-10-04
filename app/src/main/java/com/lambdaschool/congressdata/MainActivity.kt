package com.lambdaschool.congressdata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var layoutList: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var listAdapter: OverviewListAdapter? = null

    private var context: Context? = null
    private lateinit var viewModel: CongresspersonListViewModel

    var themeId: Int = 0
        private set

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        layoutList = findViewById(R.id.layout_list)
        layoutList!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        layoutList!!.layoutManager = layoutManager


        viewModel = ViewModelProviders.of(this).get(CongresspersonListViewModel::class.java!!)

        viewModel.overviewList?.observe(this, Observer { overviewList ->

                assert(overviewList != null)

                // using recycler view
                overviewList?.let {
                    listAdapter = OverviewListAdapter(overviewList)
                    layoutList!!.adapter = listAdapter
                }

        })
    }

    override fun setTheme(themeId: Int) {
        super.setTheme(themeId)
        this.themeId = themeId
    }


    override fun onStart() {
        if (themeId != themeUtils.getcTheme(this)) {
            themeUtils.refreshActivity(this)
        }
        super.onStart()
    }

    override fun onResume() {
        if (themeId != themeUtils.getcTheme(this)) {
            themeUtils.refreshActivity(this)
        }
        super.onResume()
    }

    /**
     * This method generates default TextView objects for the congressperson list in this activity.
     *
     * @param text display name for the congressperson
     * @param id   api id for the congressperson
     * @return TextView object with the text and tag set as provided
     */
    private fun getDefaultTextView(text: String, id: String): TextView {
        val dataView = TextView(context)
        dataView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
        dataView.setPadding(10, 20, 10, 20)
        dataView.typeface = Typeface.DEFAULT_BOLD
        dataView.text = text
        dataView.tag = id

        dataView.setOnClickListener { view ->
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("id", view.tag.toString())
            startActivity(intent)
        }
        return dataView
    }
}
