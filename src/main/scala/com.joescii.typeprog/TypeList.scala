package com.joescii.typeprog

sealed trait TypeList
sealed trait TNil extends TypeList
sealed trait :: extends TypeList