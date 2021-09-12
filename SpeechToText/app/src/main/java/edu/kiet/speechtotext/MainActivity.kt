package edu.kiet.speechtotext

import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.AudioManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import edu.kiet.speechtotext.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener{
    lateinit var binding:ActivityMainBinding
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    lateinit var textToSpeech: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnTexttoSpeech.isEnabled=false
        textToSpeech= TextToSpeech(this@MainActivity,this@MainActivity)
        binding.btnTexttoSpeech.setOnClickListener(View.OnClickListener {
            speakOut()
        })
        binding.btnSpeech.setOnClickListener(View.OnClickListener {
            val intent=Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault())
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say Something...")
            try{
                activityResultLauncher.launch(intent)
            }catch(exp:ActivityNotFoundException)
            {
                Toast.makeText(applicationContext,"Device does not supported",Toast.LENGTH_SHORT).show()
            }


        })
        activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult? ->
            if(result!!.resultCode== RESULT_OK && result!!.data!=null)
            {
                val speechtext=result!!.data!!.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<Editable>
                binding.txtSpeechData.text=speechtext[0]
            }
        }

    }

    private fun speakOut() {
        val textForSpeak=binding.txtSpeechData.text.toString()
        textToSpeech.speak(textForSpeak,TextToSpeech.QUEUE_FLUSH,null,null)
    }

    override fun onInit(status: Int) {
       if(status ==TextToSpeech.SUCCESS)
       {
           val res=textToSpeech.setLanguage(Locale.getDefault())
           if(res==TextToSpeech.LANG_MISSING_DATA || res==TextToSpeech.LANG_NOT_SUPPORTED)
           {
               Toast.makeText(applicationContext,"Language not supported",Toast.LENGTH_SHORT).show()
           }
           else
           {
               binding.btnTexttoSpeech.isEnabled=true
           }
       }else
       {
           Toast.makeText(applicationContext,"Failed to Initialized",Toast.LENGTH_SHORT).show()
       }
    }

    override fun onDestroy() {
        textToSpeech.stop()
        textToSpeech.shutdown()
        super.onDestroy()
    }

}