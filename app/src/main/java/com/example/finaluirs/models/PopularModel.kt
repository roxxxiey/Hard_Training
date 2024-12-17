package com.example.finaluirs.models

class PopularModel {

    private var trainImage: Int? = null
    private var trainFirstName: String = ""
    private var trainSecondName: String = ""
    private var trainDifficult: String = ""

    constructor()
    constructor(trainImage: Int?, trainFirstName: String, trainSecondName: String, trainDifficult: String) {
        this.trainImage = trainImage
        this.trainFirstName = trainFirstName
        this.trainSecondName = trainSecondName
        this.trainDifficult = trainDifficult
    }

    fun getTrainImage(): Int? {
        return trainImage
    }

    fun getFirstName(): String{
        return trainFirstName
    }

    fun getSecondName(): String{
        return trainSecondName
    }
    fun getTrainDifficult(): String{
        return trainDifficult
    }

    fun setTrainImage(trainImage: Int?){
        this.trainImage = trainImage
    }

    fun setFirstName(trainFirstName: String){
        this.trainFirstName = trainFirstName
    }

    fun setSecondName(trainSecondName: String){
        this.trainSecondName = trainSecondName
    }

    fun setTrainDifficult(trainDifficult:String){
        this.trainDifficult = trainDifficult
    }

}