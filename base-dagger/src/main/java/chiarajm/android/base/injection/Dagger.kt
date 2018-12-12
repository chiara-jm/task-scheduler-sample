package chiarajm.android.base.injection

import javax.inject.Scope

const val APPLICATION_CONTEXT = "chiarajm.android.base.application-context"
const val ACTIVITY_CONTEXT = "chiarajm.android.base.activity-context"
const val SERVICE_CONTEXT = "chiarajm.android.base.service-context"

@Scope
@Retention
annotation class ActivityScope

@Scope
@Retention
annotation class FragmentScope

@Scope
@Retention
annotation class ChildFragmentScope