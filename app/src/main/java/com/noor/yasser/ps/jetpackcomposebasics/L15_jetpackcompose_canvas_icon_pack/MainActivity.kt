package com.noor.yasser.ps.jetpackcomposebasics.L15_jetpackcompose_canvas_icon_pack

import android.graphics.Paint
import android.graphics.Path
import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getAllIcons()
        }
    }
}

@Preview
@Composable
fun getAllIcons() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            InstagramIcon()
            FacebookIcon()
            MessengerIcon()
        }

        Row(horizontalArrangement = Arrangement.SpaceAround) {
            GoogleIcon()
            YoutubeIcon()
            GooglePhotosIcon()
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            GoogleAssistant()
            GoogleAds()
            GoogleVoiceSearch()
        }
    }
}

@Composable
fun InstagramIcon() {
    val instaColors = listOf(Color.Yellow, Color.Red, Color.Magenta)

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            brush = Brush.linearGradient(colors = instaColors),
            cornerRadius = CornerRadius(60f, 60f),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 45f,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawCircle(
            brush = Brush.linearGradient(colors = instaColors),
            radius = 13f,
            center = Offset(this.size.width * .80f, this.size.height * .20f)
        )
    }

}

@Composable
fun FacebookIcon() {
    val assetManager = LocalContext.current.assets
    val paint = Paint().apply {
        textAlign = Paint.Align.CENTER
        textSize = 200f
        color = Color.White.toArgb()
        typeface = Typeface.createFromAsset(assetManager, "FACEBOLF.OTF")
    }

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawRoundRect(
            color = Color(0xFF1776d1),
            cornerRadius = CornerRadius(20f, 20f)
        )
        drawContext.canvas.nativeCanvas.drawText(
            "f",
            center.x + 25,
            center.y + 90, paint
        )

    }
}

@Composable
fun MessengerIcon() {
    val colors = listOf(Color(0xFF02b8f9), Color(0xFF0277fe))
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        val trianglePath = androidx.compose.ui.graphics.Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * .77f)
            it.lineTo(this.size.width * .20f, this.size.height * 0.95f)
            it.lineTo(this.size.width * .37f, this.size.height * 0.86f)
            it.close()
            it
        }


        val electricPath = androidx.compose.ui.graphics.Path().let {
            it.moveTo(this.size.width * .20f, this.size.height * 0.60f)
            it.lineTo(this.size.width * .45f, this.size.height * 0.35f)
            it.lineTo(this.size.width * 0.56f, this.size.height * 0.46f)
            it.lineTo(this.size.width * 0.78f, this.size.height * 0.35f)
            it.lineTo(this.size.width * 0.54f, this.size.height * 0.60f)
            it.lineTo(this.size.width * 0.43f, this.size.height * 0.45f)
            it.close()
            it
        }
        drawOval(
            Brush.verticalGradient(colors = colors),
            size = Size(this.size.width, this.size.height * 0.95f)
        )
        drawPath(
            path = trianglePath,
            Brush.verticalGradient(colors = colors),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
        drawPath(path = electricPath, color = Color.White)
    }
}


@Composable
fun GoogleIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(20.dp)
    ) {
        val width = this.size.width
        val height = this.size.height
        val path = androidx.compose.ui.graphics.Path()
        path.moveTo(width / 2, height / 2)
        path.lineTo(width + 5, height * .05f)
        path.lineTo(width + 20, height * 0.45f)

        clipPath(path = path, clipOp = ClipOp.Difference) {
            drawCircle(
                color = Color.Transparent,
                radius = 100f,
                style = Stroke(40f, cap = StrokeCap.Round)
            )
            drawPath(path = path, color = Color.Transparent)
        }

        drawRect(
            color = Color(0xFF4384f3),
            size = Size(width * .56f, 20f),
            topLeft = Offset(width * .55f, height * .45f)
        )
        drawRect(
            color = Color(0xFF4384f3),
            size = Size(width * .45f, 20f),
            topLeft = Offset(width * .55f, height * .54f)
        )
        drawArc(
            color = Color(0xFF4384f3),
            startAngle = 0f,
            sweepAngle = 45f,
            useCenter = false,
            style = Stroke(width = 40f)
        )
        drawArc(
            color = Color(0xFF33a852),
            startAngle = 45f,
            sweepAngle = 135f,
            useCenter = false,
            style = Stroke(width = 40f)
        )

        drawArc(
            color = Color(0xFFfabd03),
            sweepAngle = 80f,
            startAngle = 145f,
            useCenter = false,
            style = Stroke(width = 40f)
        )

        drawArc(
            color = Color(0xFFeb4435),
            startAngle = 205f,
            sweepAngle = 120f,
            useCenter = false,
            style = Stroke(width = 40f)
        )
    }
}

@Composable
fun YoutubeIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        val path = androidx.compose.ui.graphics.Path().apply {
            moveTo(size.width * .43f, size.height * .38f)
            lineTo(size.width * .72f, size.height * .55f)
            lineTo(size.width * .43f, size.height * .73f)
            close()
        }
        drawRoundRect(
            color = Color.Red,
            cornerRadius = CornerRadius(40f, 40f),
            size = Size(size.width, size.height * .70f),
            topLeft = Offset(size.width.times(.0f), size.height.times(.20f))
        )
        drawPath(color = Color.White, path = path)
    }
}


@Composable
private fun GooglePhotosIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        drawArc(
            color = Color(0xFFf04231),
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, 0f)
        )
        drawArc(
            color = Color(0xFF4385f7),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .50f, size.height * .25f)
        )
        drawArc(
            color = Color(0xFF30a952),
            startAngle = 0f,
            sweepAngle = -180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(0f, size.height * .25f)
        )

        drawArc(
            color = Color(0xFFffbf00),
            startAngle = 270f,
            sweepAngle = -180f,
            useCenter = true,
            size = Size(size.width * .50f, size.height * .50f),
            topLeft = Offset(size.width * .25f, size.height * .50f)
        )
    }
}


@Composable
private fun GoogleAssistant() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        val paint = Paint().apply {
            color = Color.White.toArgb()
            setShadowLayer(20f, 0f, 0f, Color.DarkGray.copy(alpha = .20f).toArgb())
        }

        drawIntoCanvas {
            it.nativeCanvas.drawOval(this.size.width, this.size.height, 0f, 0f, paint)
        }

        drawCircle(
            color = Color(0xFF4385f7),
            radius = size.width * .20f,
            center = Offset(size.width * .33f, size.height * .35f)
        )
        drawCircle(
            color = Color(0xFFf04231),
            radius = size.width * .12f,
            center = Offset(size.width * .66f, size.height * .48f)
        )
        drawCircle(
            color = Color(0xFFffbf00),
            radius = size.width * .14f,
            center = Offset(size.width * .66f, size.height * .78f)
        )
        drawCircle(
            color = Color(0xFF30a952),
            radius = size.width * .08f,
            center = Offset(size.width * .84f, size.height * .32f)
        )

    }
}

@Composable
fun GoogleAds() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {

        rotate(30f) {
            drawRoundRect(
                color = Color(0xFFffbf00),
                cornerRadius = CornerRadius(40f, 40f),
                topLeft = Offset(26f, 5f),
                size = Size(size.width * .35f, size.height)
            )
        }

        rotate(-30f) {
            drawRoundRect(
                color = Color(0xFF4385f7),
                cornerRadius = CornerRadius(40f, 40f),
                topLeft = Offset(size.width.div(2), 0f),
                size = Size(size.width * .35f, size.height)
            )
        }
        drawCircle(color = Color(0xFF30a952), radius = 35f, center = Offset(30f, 145f))
    }
}


@Composable
fun GoogleVoiceSearch() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        val paint = Paint().apply {
            color = Color.White.toArgb()
            setShadowLayer(20f, 0f, 0f, Color.DarkGray.copy(alpha = .20f).toArgb())
        }

        this.drawIntoCanvas {
            it.nativeCanvas.drawOval(this.size.width, this.size.height, 0f, 0f, paint)
        }

        drawRoundRect(
            color = Color(0xFF4385f7),
            cornerRadius = CornerRadius(40f, 40f),
            topLeft = Offset(size.width.times(.40f), size.height.times(.20f)),
            size = Size(size.width * .20f, size.height.times(.40f))
        )
        drawRect(
            color = Color(0xFF30a952),
            topLeft = Offset(size.width.times(.47f), size.height.times(.72f)),
            size = Size(size.width.times(.08f), size.height.times(.17f))
        )

        drawArc(
            color = Color(0xFFffbf00),
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = false,
            style = Stroke(width = size.width.times(.08f)),
            size = Size(size.width.times(.40f), size.height.times(.40f)),
            topLeft = Offset(size.width.times(.30f), size.height.times(.30f))
        )

        drawArc(
            color = Color(0xFFf04231),
            startAngle = 0f,
            sweepAngle = 130f,
            useCenter = false,
            style = Stroke(width = size.width.times(.08f)),
            size = Size(size.width.times(.40f), size.height.times(.40f)),
            topLeft = Offset(size.width.times(.30f), size.height.times(.30f))
        )

    }
}