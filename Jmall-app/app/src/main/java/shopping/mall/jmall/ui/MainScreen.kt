package shopping.mall.jmall.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import shopping.mall.jmall.ui.main.MainInsideScreen
import shopping.mall.jmall.ui.theme.JmallTheme
import shopping.mall.jmall.viewmodel.MainViewModel


sealed class MainNavigationItem(var route: String, val icon : ImageVector, var name: String){
    object Main : MainNavigationItem("Main", Icons.Filled.Home, "Main")
    object Category : MainNavigationItem("Category",Icons.Filled.Star, "Category")
    object MyPage : MainNavigationItem("MyPage",Icons.Filled.AccountBox, "MyPage")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JmallTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    val viewModel = hiltViewModel<MainViewModel>()
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            Header(viewModel)
        },
        scaffoldState = scaffoldState,
        bottomBar = {
            MainBottomNavigationBar(navController)
        }
    ) {
        MainNavigationScreen(viewModel = viewModel, navController = navController)
    }
}

@Composable
fun Header(viewModel : MainViewModel){
    TopAppBar(
        title = {
            Text("My App")
        },
        actions = {
            IconButton(
                onClick = {
                    viewModel.openSearchForm()
                }
            ) {
                Icon(Icons.Filled.Search, "Searching")
            }
        }
    )
}

@Composable
fun MainBottomNavigationBar(navController: NavHostController){
    val bottomNavigationItems = listOf(
        MainNavigationItem.Main,
        MainNavigationItem.Category,
        MainNavigationItem.MyPage
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavigationItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(item.icon, item.route)
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it){
                                saveState = true
                            }
                        }
                        launchSingleTop = true

                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun MainNavigationScreen(viewModel: MainViewModel, navController: NavHostController){
    NavHost(navController = navController, startDestination = MainNavigationItem.Main.route) {
        composable(MainNavigationItem.Main.route){
            MainInsideScreen(viewModel)
        }
        composable(MainNavigationItem.Category.route){
            Text(text = "Hello Category")
        }
        composable(MainNavigationItem.MyPage.route){
            Text(text = "Hello MyPage")
        }
    }
}
