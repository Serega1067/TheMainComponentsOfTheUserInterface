package com.example.android_homework.themaincomponentsoftheuserinterface

import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.android_homework.themaincomponentsoftheuserinterface.databinding.ActivityRequestCameraBinding
import java.io.File

class RequestCameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRequestCameraBinding
    private var latestFileUri: Uri? = null

    private val takePreview =
        registerForActivityResult(
            ActivityResultContracts
                .TakePicturePreview()
        ) {
            binding.imageContainer.setImageBitmap(it)
        }

    private val takePhoto =
        registerForActivityResult(
            ActivityResultContracts
                .TakePicture()
        ) { success ->
            if (success) {
                latestFileUri?.let {
                    binding.imageContainer.setImageURI(it)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestCameraBinding.inflate(layoutInflater)

        binding.takePreview.setOnClickListener {
            takePreview.launch(null)
        }

        binding.takePhoto.setOnClickListener { // при эмуляции приложения при нажатии на эту кнопку происходит ошибка
            getFileUri().let {
                latestFileUri = it
                takePhoto.launch(it)
            }
        }

        setContentView(binding.root)
    }

    private fun getFileUri(): Uri {
        val file = File.createTempFile("tmp_file", "png").apply {
            createNewFile()
            deleteOnExit()
        }
        return FileProvider.getUriForFile(
            applicationContext,
            "${BuildConfig.APPLICATION_ID}.provider",
            file
        )
    }
}