package dora.lifecycle.application

import android.app.Application
import android.content.Context
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout

class SmartRefreshLayoutApplicationLifecycle : ApplicationLifecycleCallbacks {

    override fun attachBaseContext(base: Context) {
    }

    override fun onCreate(application: Application) {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(android.R.color.white)
            ClassicsHeader(context)
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            layout.setPrimaryColorsId(android.R.color.white)
            ClassicsFooter(context)
        }
    }

    override fun onTerminate(application: Application) {
    }
}