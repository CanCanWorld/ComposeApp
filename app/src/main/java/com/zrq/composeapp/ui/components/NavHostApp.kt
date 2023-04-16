package com.zrq.composeapp.ui.components

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zrq.composeapp.ui.navigation.Destinations
import com.zrq.composeapp.ui.screens.ArticleDetailScreen
import com.zrq.composeapp.ui.screens.MainFrame
import com.zrq.composeapp.ui.screens.VideoDetailScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavHostApp() {

    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = Destinations.HomeFrame.route
    ) {
        composable(
            route = Destinations.HomeFrame.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Right)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Left)
            }
        ) {
            MainFrame(
                onNavigationToArticle = {
                    navController.navigate(Destinations.ArticleDetail.route)
                },
                onNavigationToVideo = {
                    navController.navigate(Destinations.VideoDetail.route)
                }
            )
        }

        composable(
            route = Destinations.ArticleDetail.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Left)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right)
            }) {
            ArticleDetailScreen(){
                navController.popBackStack()
            }
        }

        composable(
            route = Destinations.VideoDetail.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Left)
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right)
            }) {
            VideoDetailScreen()
        }

    }
}