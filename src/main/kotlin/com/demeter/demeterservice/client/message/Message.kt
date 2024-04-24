package com.demeter.demeterservice.client.message

import java.awt.TrayIcon.MessageType

interface Message {
    val content: String?
    val properties: Map<String?, Any?>?
    val messageType: MessageType?
}