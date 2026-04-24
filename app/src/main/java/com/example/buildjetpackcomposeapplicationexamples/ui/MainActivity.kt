package com.example.buildjetpackcomposeapplicationexamples.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.buildjetpackcomposeapplicationexamples.R
import com.example.buildjetpackcomposeapplicationexamples.ui.DifferentUiComponents.AppNavigation
import com.example.buildjetpackcomposeapplicationexamples.ui.DifferentUiComponents.setupExpressAndMetroUI
import com.example.buildjetpackcomposeapplicationexamples.ui.ui.theme.BuildJetpackComposeApplicationExamplesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildJetpackComposeApplicationExamplesTheme(
                darkTheme = false
            ) {
                var userName = userApiCall()
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    name = userName.ifBlank {
                        "Yatri"
                    }
                    navigationDrawer(name)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun navigationDrawer(userName: String?) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val context = LocalContext.current
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(300.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Row(modifier = Modifier.padding(10.dp)) {
                    pictureFormation(60)
                    Text(
                        "Welcome : $userName",
                        modifier = Modifier
                            .padding(16.dp)
                            .basicMarquee(),
                        maxLines = 1
                    )
                }
                callHorizontalLine()
                Column(Modifier.fillMaxSize(.90f)) {
                    NavigationDrawerItem(
                        label = { Text("Update Timetable") },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.drawer_first_icon),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(2.dp, 2.dp, 2.dp, 2.dp))
                                    .size(20.dp),
                                contentDescription = null
                            )
                        },
                        onClick = {
                            context.startActivity(Intent(context, LoginActivity::class.java))
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Clear Recent Searches") },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.clear_recent_search),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(2.dp, 2.dp, 2.dp, 2.dp))
                                    .size(20.dp),
                                contentDescription = null
                            )
                        },
                        onClick = {
                            Log.e("nikh", "navigationDrawer: Clear Recent Searches")
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Change City") },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.change_city),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(2.dp, 2.dp, 2.dp, 2.dp))
                                    .size(20.dp),
                                contentDescription = null
                            )
                        },
                        onClick = {
                            Log.e("nikh", "navigationDrawer: Change City")
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Settings") },
                        selected = false,
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.rail_setting),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(2.dp, 2.dp, 2.dp, 2.dp))
                                    .size(20.dp),
                                contentDescription = null
                            )
                        },
                        // Placeholder badge = { Text("20") },
                        onClick = {
                            Log.e("nikh", "navigationDrawer: Settings")
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                }
                callHorizontalLine()
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text("App Version : 0.1")
                }
            }
        },
        modifier = Modifier
            .background(Color.LightGray)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
//                            Text("Where Is My Rail")
                            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
//                            pictureFormation(70)

                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF1A237E), // Dark Indigo
                        titleContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu,
                                tint = Color.White, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(modifier = Modifier.background(Color(0xFF2C2376)).padding(innerPadding)) {
                Column(modifier = Modifier.fillMaxSize()
                    .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                    .background(Color.White)) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.White)
                            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        setupExpressAndMetroUI(navController)
                    }
                    Column(Modifier.fillMaxSize()) {
                        AppNavigation(navController)
                    }
                }

            }
        }
    }


}

private fun userApiCall(): String {
    return ""
}

@Preview(showBackground = true)
@Composable
private fun callTheUiOfMainActivity() {
    BuildJetpackComposeApplicationExamplesTheme {
        navigationDrawer("")
    }
}


@Composable
fun callHorizontalLine() {
    HorizontalDivider(
        modifier = Modifier.padding(vertical = 8.dp),
        thickness = 1.dp,
        color = Color.LightGray
    )
}




