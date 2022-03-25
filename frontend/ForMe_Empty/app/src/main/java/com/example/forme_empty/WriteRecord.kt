package com.example.forme_empty

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.TextUtils
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.jar.Manifest
import javax.sql.DataSource

class WriteRecord : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_record)

        var now = LocalDate.now()
        var strNow = now.format(DateTimeFormatter.ofPattern("MM/dd"))
        val dateText = findViewById<TextView>(R.id.todayDate)
        dateText.setText(strNow)


/*
        //카메라로 찍은 사진 가져오기
        fun selectCamera() {
            var permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            if (permission == PackageManager.PERMISSION_DENIED) {
                //권한 없음
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), REQ_CAMERA_PERMISSION)
            } else {
                //권한 있음
                var state = Environment.getExternalStorageState()
                if(TextUtils.equals(state, Environment.MEDIA_MOUNTED)) {
                    var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    intent.resolveActivity(packageManager)?.let {
                        var photoFile: File? = createImageFile()
                        photoFile?.let {
                            var photoUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", it)
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                            startActivityForResult(intent, REQ_IMAGE_CAPTURE)
                        }
                    }
                }
            }
        }

        fun createImageFile(): File {
            //사진이 저장될 폴더 있는지 체크
            var file = File(Environment.getExternalStorageDirectory(), "/path/")
            if(!file.exists()) file.mkdir()

            var imageName = "fileName.jpeg"
            var imageFile = File("${Environment.getExternalStorageDirectory().absoluteFile}/path/", "$imageName")
            imagePath = imageFile.absolutePath
            return imageFile
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (resultCode == Activity.RESULT_OK) {
                when (requestCode) {
                    REQ_IMAGE_CAPTURE -> {
                        imagePath?.apply {
                            ctSelectImage.visibility = View.VISIBLE
                            GlideUtil.loadImage(activity = this@MealsCommentActivity,
                                requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true),
                                image = imagePath,
                                imageView = ivSelectImage,
                                requestListener = object : RequestListener<Drawable> {
                                    override fun onLoadFailed(e: GlideException?, model: Any?,
                                                              target: Target<Drawable>?,
                                                              isFirstResource: Boolean): Boolean {
                                        hideLoading() return false
                                    }
                                    override fun onResourceReady(resource: Drawable?,
                                                                 model: Any?,
                                                                 target: Target<Drawable>?,
                                                                 dataSource: DataSource?,
                                                                 isFirstResource: Boolean): Boolean {
                                        hideLoading() return false
                                    }
                                })
                            checkInput()
                        }
                    }
                }
            }
        }

*/

/*
        val adapter = ArrayAdapter(
            requireContext()
        ) 
*/

        //Button참조해서 리스너 달기
        //registration페이지로 이동하기 위한 인덴트 생성
        val MainActivityIntent = Intent(this, MainActivity::class.java)
        val finButton: Button = findViewById(R.id.fin_button)
        finButton.setOnClickListener {
            startActivity(MainActivityIntent)
        }

    }


}
