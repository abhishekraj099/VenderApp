package com.example.venderapp.Screens.SignUpPage

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.venderapp.navigation.Routes

@Composable
fun SignUpScreen(viewModel: SignUpScreenViewModel, navHostController: NavHostController) {
    val userName = remember { mutableStateOf("") }
    val userNumber = remember { mutableStateOf("") }
    val userEmail = remember { mutableStateOf("") }
    val userAddress = remember { mutableStateOf("") }
    val userPinCode = remember { mutableStateOf("") }
    val userPassword = remember { mutableStateOf("") }


    when (viewModel.state.value) {
        State.DEFAULT.name -> {
            Column {
                Column(Modifier.padding(16.dp, top = 30.dp)) {
                    Text(
                        text = "Hello User!",
                        fontSize = 46.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(
                        text = "Welcome to the Inventory Management App",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    OutlinedTextField(
                        value = userName.value,
                        onValueChange = {
                            userName.value = it
                        },
                        placeholder = {
                            Text(text = "Enter Name")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Name")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Face,
                                contentDescription = "Face Icon"
                            )
                        }
                    )

                    Spacer(modifier = Modifier.size(25.dp))

                    OutlinedTextField(
                        value = userEmail.value,
                        onValueChange = {
                            userEmail.value = it
                        },
                        placeholder = {
                            Text(text = "Your Email")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Your Email")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = null
                            )
                        })

                    Spacer(modifier = Modifier.size(25.dp))

                    OutlinedTextField(
                        value = userNumber.value,
                        onValueChange = {
                            userNumber.value = it
                        },
                        placeholder = {
                            Text(text = "Phone Number")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Phone Number")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Call,
                                contentDescription = null
                            )
                        })
                    Spacer(modifier = Modifier.size(25.dp))

                    OutlinedTextField(value = userPassword.value, onValueChange = {
                        userPassword.value = it
                    }, placeholder = {
                        Text(text = "Enter Password")
                    }, modifier = Modifier.fillMaxWidth(), label = {
                        Text(text = "Create Password")
                    }, leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "Face Icon"
                        )
                    })

                    Spacer(modifier = Modifier.size(25.dp))

                    OutlinedTextField(
                        value = userPinCode.value,
                        onValueChange = {
                            userPinCode.value = it
                        },
                        placeholder = {
                            Text(text = "Your PinCode")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Your Pin Code")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = null
                            )
                        })
                    Spacer(modifier = Modifier.size(25.dp))

                    OutlinedTextField(
                        value = userAddress.value,
                        onValueChange = {
                            userAddress.value = it
                        },
                        placeholder = {
                            Text(text = "Your Address")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        minLines = 3,
                        label = {
                            Text(text = "Your Address")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = null
                            )
                        })
                    Spacer(modifier = Modifier.size(20.dp))

                    Button(
                        onClick = {
                            viewModel.createUser(
                                name = userName.value,
                                password = userPassword.value,
                                email = userEmail.value,
                                address = userAddress.value,
                                phoneNumber = userNumber.value,
                                pinCode = userPinCode.value
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Sign Up")
                    }
                }
            }
        }

        State.LOADING.name -> Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        State.FAILED.name -> Text(text = "Try Again")
        State.SUCCESS.name -> navHostController.navigate(Routes.Home)
    }


}