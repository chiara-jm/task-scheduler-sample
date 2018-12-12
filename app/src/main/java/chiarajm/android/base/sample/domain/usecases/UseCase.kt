package chiarajm.android.base.sample.domain.usecases

import chiarajm.android.common.Result
import kotlinx.coroutines.Deferred

interface UseCase<R> {

    operator fun invoke(): Deferred<Result<R>>
}