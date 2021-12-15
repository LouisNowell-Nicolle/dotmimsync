package com.mimetis.dotmim.sync.args

import com.mimetis.dotmim.sync.SyncContext
import com.mimetis.dotmim.sync.builders.DbScopeType
import com.mimetis.dotmim.sync.enumerations.SyncProgressLevel
import com.mimetis.dotmim.sync.orchestrators.BaseOrchestrator

class ScopeTableCreatingArgs(
    context: SyncContext,
    val scopeName: String,
    val scopeType: DbScopeType
) : ProgressArgs(context) {
    var cancel: Boolean = false

    override val progressLevel: SyncProgressLevel = SyncProgressLevel.Trace
    override val message = "Scope Table [$scopeType] Creating."
    override val eventId: Int = 7000
}

/**
 * Intercept the provider action when a scope table is creating
 */
fun BaseOrchestrator.onScopeTableCreating(action: (ScopeTableCreatingArgs) -> Unit) =
    this.setInterceptor(action)
