package com.loan.bgloan

import android.annotation.SuppressLint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import com.king.base.util.TimeUtils
import com.loan.bgloan.databinding.LayoutMianBinding
import com.loan.bgloan.seekerbar.dp2px
import com.loan.bgloan.utils.BitmapUtils
import com.vn.pickerview.builder.OptionsPickerBuilder
import com.vn.pickerview.builder.TimePickerBuilder
import com.vn.pickerview.listener.OnOptionsSelectListener
import com.vn.pickerview.listener.OnTimeSelectListener
import com.vn.pickerview.view.OptionsPickerView
import com.vn.pickerview.view.TimePickerView
import java.util.Date
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private lateinit var binding: LayoutMianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_mian)
        binding = LayoutMianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
}

    private fun initView() {
        val options1Items = arrayListOf("1","2")
        val options2Items: List<List<String>>  = arrayListOf(arrayListOf("1","2","3"),arrayListOf("1","2","3"))
        val options3Items: List<List<List<String>>> = arrayListOf(arrayListOf(arrayListOf("1","2","3")),arrayListOf(arrayListOf("1","2","3")),arrayListOf(arrayListOf("1","2","3")))
        val bitmapFromView =
            BitmapUtils.getBitmapFromView(binding.textProgress, 40f.dp2px(this), 20f.dp2px(this))
        val bitmapDrawable = BitmapDrawable(resources, bitmapFromView)
        binding.textBar.thumb = bitmapDrawable
        binding.textBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textProgress.text=(progress.toString())
                val bitmapFromView =
                    BitmapUtils.getBitmapFromView(binding.textProgress, 40f.dp2px(baseContext), 20f.dp2px(baseContext))
                val bitmapDrawable = BitmapDrawable(resources, bitmapFromView)
                binding.textBar.thumb = bitmapDrawable
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        binding.pickeroptions.setOnClickListener {
            //条件选择器
            val pvOptions: OptionsPickerView<String> =
                OptionsPickerBuilder(this@MainActivity
                ) { options1, option2, options3, v -> //返回的分别是三个级别的选中位置
                    val tx: String = (options1Items.get(options1)
                            + options2Items.get(options1).get(option2)
                            + options3Items.get(options1).get(option2).get(options3))
                    binding.pickeroptions.setText(tx)
                }.build()

            pvOptions.setPicker(options1Items, options2Items, options3Items)
            pvOptions.show()
        }
        binding.picker.setOnClickListener {

            //时间选择器
            val pvTime: TimePickerView =
                TimePickerBuilder(this@MainActivity
                ) { date, v ->
                    Toast.makeText(
                        this@MainActivity,
                        TimeUtils.formatDate(date, TimeUtils.FORMAT_Y_TO_D),
                        Toast.LENGTH_SHORT
                    ).show()
                }.build()
            pvTime.show()



        }



    }
}
