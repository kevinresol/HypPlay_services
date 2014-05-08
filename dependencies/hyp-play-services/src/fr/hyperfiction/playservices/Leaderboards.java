package fr.hyperfiction.playservices;

import android.util.Log;
import com.google.android.gms.games.Games;
import fr.hyperfiction.playservices.PlayHelper;

import fr.hyperfiction.googleplayservices.HypPlayServices;

/**
 * ...
 * @author shoe[box]
 */

class Leaderboards{

	private static final int ID_LEADERBOARD_INTENT = 5003;

	// -------o constructor

		/**
		* constructor
		*
		* @param
		* @return	void
		*/
		private Leaderboards() {

		}

	// -------o public

		/**
		*
		*
		* @public
		* @return	void
		*/
		static public void openAll(  ){
			HypPlayServices.mainActivity.startActivityForResult(
				Games.Leaderboards.getAllLeaderboardsIntent(
					PlayHelper.getInstance( ).getApiClient()
				),			
				ID_LEADERBOARD_INTENT
			);
		}

		/**
		*
		*
		* @public
		* @return	void
		*/
		static public void openBy_id( String sId ){
			HypPlayServices.mainActivity.startActivityForResult(
				Games.Leaderboards.getLeaderboardIntent(
					PlayHelper.getInstance( ).getApiClient(),
					sId
				),			
				ID_LEADERBOARD_INTENT
			);
		}

		/**
		*
		*
		* @public
		* @return	void
		*/
		static public void loadMeta_datas( String sId ){
			//PlayHelper.getInstance( ).getApiClient( ).loadLeaderboardMetadata( PlayHelper.getInstance( ) , sId );
		}

		/**
		*
		*
		* @public
		* @return	void
		*/
		static public void submitScore( String sId , int iScore , boolean bSync ){
			if (!bSync )
				Games.Leaderboards.submitScore(PlayHelper.getInstance( ).getApiClient( ), sId, (long)iScore);
			else
				Games.Leaderboards.submitScoreImmediate(PlayHelper.getInstance( ).getApiClient( ), sId, (long)iScore);
		}

	// -------o protected

	// -------o misc

		/*
		*
		*
		* @private
		* @return	void
		*/
		public static void trace( String s ){
			Log.w( TAG, "Leaderboards ::: "+s );
		}
		private static String TAG = "HypPS";
}