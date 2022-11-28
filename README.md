# Check_Personal_App 이름 궁합

## 🎯 Use stack & skill
- Kotlin 100%
- Kotlin DSL
- Firebase RTDB
- Firestore
- MVVM
- Clean Architecture
- ACC
- Dagger Hilt
- DataBinding
- BindingAdapter

<br>

## 👀 App tructure
#### App module(Di) -> Presentation module(View, ViewModel) -> Domain module(Repository, Usecase) -> Data module(Repository, Mapper, Remote)

### <br>

```
|── app
|   └── di
|       ├── App.kt
|       ├── DataSourceModule.kt
|       ├── FirebaseModule.kt
|       ├── NetworkModule.kt
|       └── RepositoryModule.kt
|       └── UseCaseModule.kt
|   └── utils
|       └── Utils
|
│── presentation
│   ├── adapter
│   │   ├── ScoreBindingAdapter.kt
│   │   └── ScoreRecyclerViewAdapter.kt
│   ├── base
│   │   ├── BaseActivity.kt
│   │   └── BaseFragment.kt
│   ├── view
│   │   ├── MainActivity.kt
│   │   ├── MainFragment.kt
│   │   ├── ManNameFragment.kt
│   │   ├── ResultFragment.kt
│   │   ├── SplashActivity.kt
│   │   └── WomanNameFragment.kt
│   ├── viewmodel
│   │   ├── MainViewModel.kt
│   │   └── SplashViewModel.kt
│   └── widget
│       ├── extension
│       │   ├── ActivityExtension.kt
│       │   └── FragmentExtension.kt
│       └── utils
│           └── SingleLiveEvent.kt
│
├── domain
│   ├── model
│   │   ├── DomainLoveResponse.kt
│   │   └── DomainScore.kt
│   ├── repository
│   │   ├── MainRepository.kt
│   │   └── SplashRepository.kt
│   ├── usecase
│   │   ├── CheckAppVersionUseCase.kt
│   │   ├── CheckLoveCalculatorUseCase.kt
│   │   ├── GetScoreUseCase.kt
│   │   ├── GetStatisticsUseCase.kt
│   │   ├── SetScoreUseCase.kt
│   │   └── SetStatisticsUseCase.kt
│   └── utils
│       ├── ErrorType.kt
│       ├── RemoteErrorEmitter.kt
│       └── ScreenState.kt
│
├── data
│   ├── mapper
│   │   └── MainMapper.kt
│   ├── remote
│   │   ├── api
│   │   │   └── LoveCalculatorApi.kt
│   │   └── model
│   │       ├── DataLoveResponse.kt
│   │       └── DataScore.kt
│   ├── repository
│   │   ├── remote
│   │   │   ├── datasource
│   │   │   │   ├── MainDataSource.kt
│   │   │   │   └── SplashDataSource.kt
│   │   │   └── datasourceimpl
│   │   │       ├── MainDataSourceImpl.kt
│   │   │       └── SplashDataSourceImpl.kt
│   │   ├── MainRepositoryImpl.kt
│   │   └── SplashRepositoryImpl.kt
│   └── utils
│       └── base
│           └── BaseDataSource.kt
│   
└── buildSrc
    └── Dependency.kt
```
<br>