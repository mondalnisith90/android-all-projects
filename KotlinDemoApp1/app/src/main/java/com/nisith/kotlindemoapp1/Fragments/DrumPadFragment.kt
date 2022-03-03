package com.nisith.kotlindemoapp1.Fragments

import android.graphics.Color
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import com.nisith.kotlindemoapp1.Constants
import com.nisith.kotlindemoapp1.MySharedPreference
import com.nisith.kotlindemoapp1.R
import kotlin.properties.Delegates

class DrumPadFragment : Fragment() {

    private lateinit var rootView: RelativeLayout
    private lateinit var soundPool: SoundPool
    private var sound1 by Delegates.notNull<Int>()
    private var sound2 by Delegates.notNull<Int>()
    private var sound3 by Delegates.notNull<Int>()
    private var sound4 by Delegates.notNull<Int>()
    private var sound5 by Delegates.notNull<Int>()
    private var sound6 by Delegates.notNull<Int>()
    private var sound7 by Delegates.notNull<Int>()
    private var sound8 by Delegates.notNull<Int>()
    private var sound9 by Delegates.notNull<Int>()
    private var sound10 by Delegates.notNull<Int>()
    private var sound11 by Delegates.notNull<Int>()
    private var sound12 by Delegates.notNull<Int>()
    private var sound13 by Delegates.notNull<Int>()
    private var sound14 by Delegates.notNull<Int>()
    private val totalSounds: Int = 14

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("ABCDE","onCreateView() is called")
        val view: View = inflater.inflate(R.layout.fragment_dram_pad, container, false)
        rootView = view.findViewById(R.id.root_view)
        setClickListeners(view)
        return view

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var audioAttributes: AudioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setMaxStreams(totalSounds)
            .setAudioAttributes(audioAttributes)
            .build()
        sound1 = soundPool.load(this.context, R.raw.ses0, 1)
        sound2 = soundPool.load(this.context, R.raw.ses1, 1)
        sound3 = soundPool.load(this.context, R.raw.ses2, 1)
        sound4 = soundPool.load(this.context, R.raw.ses3, 1)
        sound5 = soundPool.load(this.context, R.raw.ses4, 1)
        sound6 = soundPool.load(this.context, R.raw.ses5, 1)
        sound7 = soundPool.load(this.context, R.raw.ses6, 1)
        sound8 = soundPool.load(this.context, R.raw.ses7, 1)
        sound9 = soundPool.load(this.context, R.raw.ses8, 1)
        sound10 = soundPool.load(this.context, R.raw.ses9, 1)
        sound11 = soundPool.load(this.context, R.raw.ses10, 1)
        sound12 = soundPool.load(this.context, R.raw.ses11, 1)
        sound13 = soundPool.load(this.context, R.raw.ses12, 1)
        sound14 = soundPool.load(this.context, R.raw.ses13, 1)
        setBackgroundColor()

    }


    fun setBackgroundColor(){
        val backgroundTheme = context?.let { MySharedPreference(it).getSavedBackgroundTheme() }
        if(backgroundTheme == Constants.DARK_THEME){
            rootView.setBackgroundColor(Color.BLACK)
        }else{
            rootView.setBackgroundColor(Color.WHITE)
        }


    }


    private inner class MyButtonClickListener: View.OnClickListener{
        override fun onClick(view: View?) {
            view?.let {
                //Means if view != null
                when(view.id){
                    R.id.button1 -> {
                     soundPool.play(sound1, 1f,1f,0,1,1f)
                    }
                    R.id.button2 -> {
                        soundPool.play(sound2, 1f,1f,0,1,1f)
                    }
                    R.id.button3 -> {
                        soundPool.play(sound3, 1f,1f,0,1,1f)
                    }
                    R.id.button4 -> {
                        soundPool.play(sound4, 1f,1f,0,1,1f)
                    }
                    R.id.button5 -> {
                        soundPool.play(sound6, 1f,1f,0,1,1f)
                    }
                    R.id.button6 -> {
                        soundPool.play(sound6, 1f,1f,0,0,1f)
                    }
                    R.id.button7 -> {
                        soundPool.play(sound7, 1f,1f,0,1,1f)
                    }
                    R.id.button8 -> {
                        soundPool.play(sound7, 1f,1f,0,0,1f)
                    }
                    R.id.button9 -> {
                        soundPool.play(sound9, 1f,1f,0,0,1f)
                    }
                    R.id.button10 -> {
                        soundPool.play(sound10, 1f,1f,0,0,1f)
                    }
                    R.id.button11 -> {
                        soundPool.play(sound11, 1f,1f,0,0,1f)
                    }
                    R.id.button12 -> {
                        soundPool.play(sound12, 1f,1f,0,0,1f)
                    }
                    R.id.button13 -> {
                        soundPool.play(sound13, 1f,1f,0,0,1f)
                    }
                    R.id.button14 -> {
                        soundPool.play(sound14, 1f,1f,0,0,1f)
                    }
                    R.id.button15 -> {
                        soundPool.play(sound6, 1f,1f,0,0,1f)
                    }
                    R.id.button16 -> {
                        soundPool.play(sound7, 1f,1f,0,0,1f)
                    }
                    else ->{}

                }
            }

        }

    }


    override fun onDestroy() {
        super.onDestroy()
        //Release SoundPool Memory from RAM
        soundPool.release()
    }





    private fun setClickListeners(view: View){
        val button1: Button = view.findViewById(R.id.button1)
        val button2: Button = view.findViewById(R.id.button2)
        val button3: Button = view.findViewById(R.id.button3)
        val button4: Button = view.findViewById(R.id.button4)
        val button5: Button = view.findViewById(R.id.button5)
        val button6: Button = view.findViewById(R.id.button6)
        val button7: Button = view.findViewById(R.id.button7)
        val button8: Button = view.findViewById(R.id.button8)
        val button9: Button = view.findViewById(R.id.button9)
        val button10: Button = view.findViewById(R.id.button10)
        val button11: Button = view.findViewById(R.id.button11)
        val button12: Button = view.findViewById(R.id.button12)
        val button13: Button = view.findViewById(R.id.button13)
        val button14: Button = view.findViewById(R.id.button14)
        val button15: Button = view.findViewById(R.id.button15)
        val button16: Button = view.findViewById(R.id.button16)
        button1.setOnClickListener(MyButtonClickListener())
        button2.setOnClickListener(MyButtonClickListener())
        button3.setOnClickListener(MyButtonClickListener())
        button4.setOnClickListener(MyButtonClickListener())
        button5.setOnClickListener(MyButtonClickListener())
        button6.setOnClickListener(MyButtonClickListener())
        button7.setOnClickListener(MyButtonClickListener())
        button8.setOnClickListener(MyButtonClickListener())
        button9.setOnClickListener(MyButtonClickListener())
        button10.setOnClickListener(MyButtonClickListener())
        button11.setOnClickListener(MyButtonClickListener())
        button12.setOnClickListener(MyButtonClickListener())
        button13.setOnClickListener(MyButtonClickListener())
        button14.setOnClickListener(MyButtonClickListener())
        button15.setOnClickListener(MyButtonClickListener())
        button16.setOnClickListener(MyButtonClickListener())
    }



}