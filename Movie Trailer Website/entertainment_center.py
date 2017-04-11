import movie
import fresh_tomatoes

#Create instances of my favorite movies
captain_america_cw = movie.Movie("Captain America: Civil War",
                                 "Political interference in the Avengers'"
                                 "activities causes a rift between former"
                                 "allies Captain America and Iron Man.",
                                 "https://upload.wikimedia.org/wikipedia/en/5/53/Captain_America_Civil_War_poster.jpg",  # noqa
                                 "https://www.youtube.com/watch?v=dKrVegVI0Us")

psycho_pass = movie.Movie("Psycho-Pass: The Movie",
                          "In this sequel to Psycho-Pass TV show, Inspector"
                          "Tsunemori is sent to a neighboring war-torn nation,"
                          "where the Sibyl System is being introduced as an"
                          "experiment, to find Shinya Kogami, her former"
                          "enforcerwho went rogue three years ago.",
                          "https://upload.wikimedia.org/wikipedia/en/a/a1/Psycho-Pass_The_Movie_Visual.jpg",  # noqa
                          "https://www.youtube.com/watch?v=GY36cxjaN9I")

jupiter_ascending = movie.Movie("Jupiter Ascending",
                                "A young woman discovers her "
                                "destiny as an heiress of "
                                "intergalactic nobility and must "
                                "fight to protectthe inhabitants of Earth "
                                "from an ancient and destructive industry.",
                                "https://upload.wikimedia.org/wikipedia/en/7/76/%27Jupiter_Ascending%27_Theatrical_Poster.jpg",  # noqa
                                "https://www.youtube.com/watch?v=ZoCyL_Pqzu8")

maleficent = movie.Movie("Maleficent",
                         "A vengeful fairy is driven to curse "
                         " an infant princess, only to discover "
                         " that the child may be the one person "
                         "who can restore peace to their troubled land.",
                         "https://upload.wikimedia.org/wikipedia/en/5/55/Maleficent_poster.jpg",  # noqa
                         "https://www.youtube.com/watch?v=w-XO4XiRop0")

fantastic_beasts = movie.Movie("Fantastic Beasts and Where to Find Them",
                               "The adventures of writer Newt Scamander in New"
                               "York's secret community of witches and wizards"
                               "seventy years before Harry Potter reads his"
                               "book in school.",
                               "https://upload.wikimedia.org/wikipedia/en/5/5e/Fantastic_Beasts_and_Where_to_Find_Them_poster.png",  # noqa
                               "https://www.youtube.com/watch?v=YdgQj7xcDJo")

spirited_away = movie.Movie("Spirited Away",
                            "During her family's move to the suburbs, a sullen"
                            "10-year-old girl wanders into a world ruled "
                            "by gods, witches, and spirits, and where "
                            "humans are changed into beasts.",
                            "https://upload.wikimedia.org/wikipedia/en/3/30/Spirited_Away_poster.JPG",  # noqa
                            "https://www.youtube.com/watch?v=ByXuk9QqQkk")
#Define movie array
movies = [captain_america_cw, psycho_pass, jupiter_ascending,
          maleficent, fantastic_beasts, spirited_away]

#Launch the fresh_tomatoes file to generate html
fresh_tomatoes.open_movies_page(movies)
