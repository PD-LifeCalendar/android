package com.example.lifecalendar.di

import android.content.Context
import com.example.lifecalendar.domain.usecase.*
import com.example.lifecalendar.ui.fragment.add_node.AddNodeViewModelFactory
import com.example.lifecalendar.ui.fragment.edit_node.EditNodeViewModelFactory
import com.example.lifecalendar.ui.fragment.goals.GoalsViewModelFactory
import com.example.lifecalendar.ui.fragment.life_calendar.LifeCalendarViewModelFactory
import com.example.lifecalendar.ui.fragment.login.LoginViewModelFactory
import com.example.lifecalendar.ui.fragment.selected_year.SelectedYearViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    
    @Provides
    fun provideContext(): Context {
        return context
    }
    
    @Provides
    fun provideLoginViewModelFactory(
        loginUseCase: LoginUseCase,
        refreshTokenUseCase: RefreshTokenUseCase
    ): LoginViewModelFactory {
        return LoginViewModelFactory(
            loginUseCase = loginUseCase,
            refreshTokenUseCase = refreshTokenUseCase
        )
    }
    
    @Provides
    fun provideLifeCalendarViewModelFactory(): LifeCalendarViewModelFactory {
        return LifeCalendarViewModelFactory()
    }

    @Provides
    fun provideGoalsModuleFactory(): GoalsViewModelFactory {
        return GoalsViewModelFactory()
    }

    @Provides
    fun provideSelectedYearViewModelFactory(
        fetchYearNodesUseCase: FetchYearNodesUseCase,
        deleteNodeByIdUseCase: DeleteNodeByIdUseCase
    ): SelectedYearViewModelFactory {
        return SelectedYearViewModelFactory(
            fetchYearNodesUseCase = fetchYearNodesUseCase,
            deleteNodeByIdUseCase = deleteNodeByIdUseCase
        )
    }
    
    @Provides
    fun provideAddNodeViewModelFactory(addYearNodeUseCase: AddYearNodeUseCase): AddNodeViewModelFactory {
        return AddNodeViewModelFactory(addYearNodeUseCase = addYearNodeUseCase)
    }
    
    @Provides
    fun provideEditNodeViewModelFactory(updateNodeUseCase: UpdateNodeUseCase): EditNodeViewModelFactory {
        return EditNodeViewModelFactory(updateNodeUseCase = updateNodeUseCase)
    }
    
}