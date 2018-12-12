package chiarajm.android.base

import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing


fun <T> whenever(t: T): OngoingStubbing<T> = Mockito.`when`(t)