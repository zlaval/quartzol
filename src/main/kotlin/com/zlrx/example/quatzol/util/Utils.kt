package com.zlrx.example.quatzol.util

import com.chrylis.codec.base58.Base58UUID
import java.util.*


fun newId(): String = Base58UUID().encode(UUID.randomUUID())