INSERT INTO specific_locations (name, country_id)
VALUES
('Wachau Valley', (SELECT id FROM countries WHERE name = 'Austria')),
('Gosau Valley', (SELECT id FROM countries WHERE name = 'Austria')),
('Zillertal Alps', (SELECT id FROM countries WHERE name = 'Austria')),

('Ardennes Forest', (SELECT id FROM countries WHERE name = 'Belgium')),
('Zwin Nature Reserve', (SELECT id FROM countries WHERE name = 'Belgium')),
('Hallerbos', (SELECT id FROM countries WHERE name = 'Belgium')),

('Una National Park', (SELECT id FROM countries WHERE name = 'Bosnia and Herzegovina')),
('Blidinje Nature Park', (SELECT id FROM countries WHERE name = 'Bosnia and Herzegovina')),
('Una River Waterfalls', (SELECT id FROM countries WHERE name = 'Bosnia and Herzegovina')),

('Plitvice Lakes National Park', (SELECT id FROM countries WHERE name = 'Croatia')),
('Brijuni National Park', (SELECT id FROM countries WHERE name = 'Croatia')),
('Kornati Islands', (SELECT id FROM countries WHERE name = 'Croatia')),

('Troodos Mountains', (SELECT id FROM countries WHERE name = 'Cyprus')),
('Akamas Peninsula', (SELECT id FROM countries WHERE name = 'Cyprus')),
('Cape Greco', (SELECT id FROM countries WHERE name = 'Cyprus')),

('Bohemian Switzerland', (SELECT id FROM countries WHERE name = 'Czech Republic')),
('Moravian Karst', (SELECT id FROM countries WHERE name = 'Czech Republic')),
('Krkonoše National Park', (SELECT id FROM countries WHERE name = 'Czech Republic')),

('Mols Bjerge National Park', (SELECT id FROM countries WHERE name = 'Denmark')),
('Rubjerg Knude', (SELECT id FROM countries WHERE name = 'Denmark')),
('Møns Klint', (SELECT id FROM countries WHERE name = 'Denmark')),

('Malbun', (SELECT id FROM countries WHERE name = 'Liechtenstein')),
('Berggasthaus Sücka', (SELECT id FROM countries WHERE name = 'Liechtenstein')),
('Princess Gina Trail', (SELECT id FROM countries WHERE name = 'Liechtenstein')),

('Curonian Spit', (SELECT id FROM countries WHERE name = 'Lithuania')),
('Dzūkija National Park', (SELECT id FROM countries WHERE name = 'Lithuania')),
('Hill of Witches', (SELECT id FROM countries WHERE name = 'Lithuania')),

('Mullerthal Trail', (SELECT id FROM countries WHERE name = 'Luxembourg')),
('Upper Sûre Natural Park', (SELECT id FROM countries WHERE name = 'Luxembourg')),
('Moser Plateau', (SELECT id FROM countries WHERE name = 'Luxembourg')),

('Gozo', (SELECT id FROM countries WHERE name = 'Malta')),
('Comino', (SELECT id FROM countries WHERE name = 'Malta')),
('Dwejra Bay', (SELECT id FROM countries WHERE name = 'Malta')),

('Zaanse Schans', (SELECT id FROM countries WHERE name = 'Netherlands')),
('Giethoorn', (SELECT id FROM countries WHERE name = 'Netherlands')),
('Kinderdijk', (SELECT id FROM countries WHERE name = 'Netherlands')),

('Montserrat Mountains', (SELECT id FROM countries WHERE name = 'Spain')),
('Cabo de Gata-Níjar Natural Park', (SELECT id FROM countries WHERE name = 'Spain')),
('Monte Perdido', (SELECT id FROM countries WHERE name = 'Spain')),

('Seven Sisters Cliffs', (SELECT id FROM countries WHERE name = 'United Kingdom')),
('Lake District National Park', (SELECT id FROM countries WHERE name = 'United Kingdom')),
('Snowdonia National Park', (SELECT id FROM countries WHERE name = 'United Kingdom'));
