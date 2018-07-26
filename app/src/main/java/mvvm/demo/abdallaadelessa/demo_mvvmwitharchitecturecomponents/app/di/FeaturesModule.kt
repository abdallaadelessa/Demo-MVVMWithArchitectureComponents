package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di

import dagger.Module
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines.ListAirlinesModule

@Module (includes = [
    ListAirlinesModule::class
])
abstract class FeaturesModule{
}