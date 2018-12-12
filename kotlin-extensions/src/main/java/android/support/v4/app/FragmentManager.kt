package android.support.v4.app

inline fun FragmentManager.commit(block: FragmentTransaction.() -> Unit) {
    beginTransaction().run {
        block(this)
        commit()
    }
}


inline fun FragmentManager.commitAllowingStateLoss(block: FragmentTransaction.() -> Unit) {
    beginTransaction().run {
        block(this)
        commitAllowingStateLoss()
    }
}


inline fun FragmentManager.commitNow(block: FragmentTransaction.() -> Unit) {
    beginTransaction().run {
        block(this)
        commitNow()
    }
}

inline fun FragmentManager.commitNowAllowingStateLoss(block: FragmentTransaction.() -> Unit) {
    beginTransaction().run {
        block(this)
        commitNowAllowingStateLoss()
    }
}