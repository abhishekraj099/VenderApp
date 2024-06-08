package com.example.venderapp.Screens.SignUpPage

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun SignUpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(),)

    ) {
        OutlinedTextField( //OutlinedTextField is a textfield with an outline border.
            value = "", onValueChange = {},
            placeholder = {
                Text(text = "Enter your name")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 25.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = "", onValueChange = {},
            placeholder = {
                Text(text = "Password")
            }, modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = "", onValueChange = {},
            placeholder = {
                Text(text = "Your Phone Number")
            }, modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = "", onValueChange = {},
            placeholder = {
                Text(text = "Your Email")
            }, modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = "", onValueChange = {},
            placeholder = {
                Text(text = "Your PinCode")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = "", onValueChange = {},
            placeholder = {
                Text(text = "Your Address")
            },

            modifier = Modifier.align(Alignment.CenterHorizontally),
            minLines = 3   //it will make the textfield 3 lines of height and will allow multiline input in the textfield.
        )
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
        ) {
            Text(text = "Sign Up")

        }

    }
}