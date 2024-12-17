package com.example.finaluirs.models

class BestModel {

    private var bestTrainImage:Int? = null
    private var bestTrainHeading: String = ""
    private var bestTrainConxept: String = ""
    private var bestTrainDifficult: String = ""

    constructor(bestTrainImage:Int?, bestTrainHeading: String, bestTrainConxept: String, bestTrainDifficult: String){
        this.bestTrainImage = bestTrainImage
        this.bestTrainHeading = bestTrainHeading
        this.bestTrainConxept = bestTrainConxept
        this.bestTrainDifficult = bestTrainDifficult
    }

    fun getBestTrainImage():Int?{
        return bestTrainImage
    }
    fun getBestTrainHeading():String{
        return bestTrainHeading
    }
    fun getBestTrainConxept():String{
        return bestTrainConxept
    }
    fun getBestTrainDifficult():String{
        return bestTrainDifficult
    }

}