package game;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Scanner;


public final class RessourcesFactory
{
	// singleton
	private static RessourcesFactory instance = null;
	private Scanner mapFile;
	
	/**
	 * Constructeur pour le Singleton
	 */
	private RessourcesFactory() 
	{
		// La pr�sence d'un constructeur priv� supprime
		// le constructeur public par d�faut.
		// Qui plus est seul le singleton peut s'instancier lui m�me
		super();
	}

	/**
	 * Accesseur pour le singleton
	 * <i> Utile pour acc�der au getClass() permettant de charger des resources audios</i>
	 * 
	 * @return l'instance unique vers ResourcesFactory
	 */
	public final synchronized static RessourcesFactory getInstance()
	{
		// Le mot-cl� synchronized sur la m�thode de cr�ation emp�che 
		// toute instanciation multiple m�me par diff�rents threads.
		// Il est TRES important.
		if( instance == null )
		{
			instance = new RessourcesFactory();
		}

		return instance;
	}

	/**
	 * Chargement d'une ressource image
	 * @param path  le chemin vers la ressource
	 * 
	 * @return l'instance vers l'image cr��e
	 */
	public Image loadingResourceImage(String path) 
	{
		Image monImage = null;
		try 
		{
			monImage = Toolkit.getDefaultToolkit().getImage(path); 
		} 
		catch (Exception e)
		{
			System.out.println("L'image " + path + " n'existe pas");
		}
		return monImage;
	}
	
	/**
	 * Chargement d'un fichier ressource
	 * @param path
	 * @return
	 */
	public Scanner loadingResourceFile(String path) 
	{
		Scanner monScanner = null;
		try
		{
			monScanner = new Scanner(new File(path));
		}
		catch(Exception e)
		{
			System.out.println("Le fichier " + path + " n'existe pas");
		}
		return monScanner;
	}


	public Scanner getMapFile(String MapFilePath)
	{
		if( mapFile == null )
		{	
			mapFile = loadingResourceFile(MapFilePath);
		}
		return mapFile;
	}
	
}