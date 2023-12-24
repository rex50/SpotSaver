package com.spot.saver.data.repo.spot

import com.spot.saver.enums.LabelType
import com.spot.saver.enums.Result
import com.spot.saver.util.dummySpotDetail
import com.spot.saver.view.model.SpotDetailUiModel
import com.spot.saver.view.model.SpotLabelUiModel
import kotlinx.coroutines.delay
import kotlin.random.Random

class SpotsRepoImpl: SpotsRepo {
    override suspend fun fetchSavedSpots(): Result<List<SpotDetailUiModel>> {
        delay(500)
        val spots = mutableListOf<SpotDetailUiModel>()
        (1..30).forEach {
            spots.add(
                dummySpotDetail.copy(
                    id = "$it",
                    title = names.random(),
                    imageUrl = images.random(),
                    totalImages = if(it%10 == 0) 0 else Random.nextInt(1, 20),
                    labels = listOf(labels.random())
                )
            )
        }
        return Result.Success(spots)
    }


    private val names = listOf(
        "37 Rockledge Dr.\n" +
                "Levittown, NY 11756",
        "1 Thorne Lane\n" +
                "Allentown, PA 18102",
        "803 Fulton St.\n" +
                "Lumberton, NC 28358",
        "9250 Valley Farms Street\n" +
                "Florence, SC 29501",
        "7254 Campfire St.\n" +
                "Sun City, AZ 85351",
        "218 East Newport Drive\n" +
                "Avon Lake, OH 44012"
    )

    private val labels = listOf(
        SpotLabelUiModel("Expires in 4 hours", LabelType.EXPIRY_RED),
        SpotLabelUiModel("Expires in 24 hours", LabelType.EXPIRY_YELLOW),
        SpotLabelUiModel("Expires in 1 month", LabelType.EXPIRY_GREEN),
        SpotLabelUiModel("General label", LabelType.GENERAL),
    )

    private val images = listOf(
        "https://images.unsplash.com/photo-1517713982677-4b66332f98de?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGxhY2VzfGVufDB8fDB8fHww",
        "https://images.unsplash.com/photo-1556905200-279565513a2d?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8cGxhY2VzfGVufDB8fDB8fHww",
        "https://images.unsplash.com/photo-1549877452-9c387954fbc2?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8cGxhY2VzfGVufDB8fDB8fHww",
        "https://images.unsplash.com/photo-1570143675316-51a19f90a943?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fHBsYWNlc3xlbnwwfHwwfHx8MA%3D%3D",
        "https://images.unsplash.com/photo-1583647515538-3f4f972971cd?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fHBsYWNlc3xlbnwwfHwwfHx8MA%3D%3D",
        "https://plus.unsplash.com/premium_photo-1675756583711-ce312872227b?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjV8fHBsYWNlc3xlbnwwfHwwfHx8MA%3D%3D",
        "https://images.unsplash.com/photo-1594376425830-449d2b7572d5?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzJ8fHBsYWNlc3xlbnwwfHwwfHx8MA%3D%3D",
        "https://plus.unsplash.com/premium_photo-1676049111274-3ec809c03516?w=700&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mzd8fHBsYWNlc3xlbnwwfHwwfHx8MA%3D%3D"
    )
}