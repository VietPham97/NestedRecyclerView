package com.espresslabs.nestedrecyclerview

data class ParentModel(
    val title: String = "",
    val children: List<ChildModel>
)