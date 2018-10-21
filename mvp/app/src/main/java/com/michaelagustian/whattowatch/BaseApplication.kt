package com.michaelagustian.whattowatch

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.michaelagustian.whattowatch.di.component.ApplicationComponent
import com.michaelagustian.whattowatch.di.component.DaggerApplicationComponent
import com.michaelagustian.whattowatch.di.module.ApplicationModule
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by Michael Agustian on 20/10/18.
 */

class BaseApplication : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        // Initialization
        Fresco.initialize(this)

        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)

        applicationComponent = initDagger(this)
    }

    private fun initDagger(application: BaseApplication): ApplicationComponent =
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(application))
            .build()
}