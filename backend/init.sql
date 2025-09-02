-- =========================
-- CREACIÓN DE TABLAS
-- =========================
CREATE TABLE departamento (
  id BIGSERIAL PRIMARY KEY,
  codigo VARCHAR(50) UNIQUE,
  nombre VARCHAR(100) NOT NULL
);

CREATE TABLE ciudad (
  id BIGSERIAL PRIMARY KEY,
  codigo VARCHAR(50) UNIQUE,
  nombre VARCHAR(100) NOT NULL,
  departamento_id BIGINT REFERENCES departamento(id)
);

CREATE TABLE material (
  id BIGSERIAL PRIMARY KEY,
  nombre VARCHAR(200) NOT NULL,
  descripcion TEXT,
  tipo VARCHAR(100),
  precio NUMERIC(12,2),
  fecha_compra DATE NOT NULL,
  fecha_venta DATE NOT NULL,
  estado VARCHAR(50),
  ciudad_id BIGINT REFERENCES ciudad(id)
);

-- ===============================
-- 1. Departamentos
-- ===============================
INSERT INTO departamento (codigo, nombre) VALUES
('DEP001', 'Antioquia'),
('DEP002', 'Cundinamarca'),
('DEP003', 'Valle del Cauca'),
('DEP004', 'Santander'),
('DEP005', 'Atlántico');

-- ===============================
-- 2. Ciudades (20)
-- ===============================
INSERT INTO ciudad (codigo, nombre, departamento_id) VALUES
('C001', 'Medellín', (SELECT id FROM departamento WHERE codigo='DEP001')),
('C002', 'Bello', (SELECT id FROM departamento WHERE codigo='DEP001')),
('C003', 'Envigado', (SELECT id FROM departamento WHERE codigo='DEP001')),
('C004', 'Itagüí', (SELECT id FROM departamento WHERE codigo='DEP001')),

('C005', 'Bogotá', (SELECT id FROM departamento WHERE codigo='DEP002')),
('C006', 'Soacha', (SELECT id FROM departamento WHERE codigo='DEP002')),
('C007', 'Chía', (SELECT id FROM departamento WHERE codigo='DEP002')),
('C008', 'Zipaquirá', (SELECT id FROM departamento WHERE codigo='DEP002')),

('C009', 'Cali', (SELECT id FROM departamento WHERE codigo='DEP003')),
('C010', 'Palmira', (SELECT id FROM departamento WHERE codigo='DEP003')),
('C011', 'Jamundí', (SELECT id FROM departamento WHERE codigo='DEP003')),
('C012', 'Yumbo', (SELECT id FROM departamento WHERE codigo='DEP003')),

('C013', 'Bucaramanga', (SELECT id FROM departamento WHERE codigo='DEP004')),
('C014', 'Floridablanca', (SELECT id FROM departamento WHERE codigo='DEP004')),
('C015', 'Girón', (SELECT id FROM departamento WHERE codigo='DEP004')),
('C016', 'Piedecuesta', (SELECT id FROM departamento WHERE codigo='DEP004')),

('C017', 'Barranquilla', (SELECT id FROM departamento WHERE codigo='DEP005')),
('C018', 'Soledad', (SELECT id FROM departamento WHERE codigo='DEP005')),
('C019', 'Puerto Colombia', (SELECT id FROM departamento WHERE codigo='DEP005')),
('C020', 'Malambo', (SELECT id FROM departamento WHERE codigo='DEP005'));

-- ===============================
-- 3. Materiales (15)
-- ===============================
INSERT INTO material (nombre, descripcion, tipo, precio, fecha_compra, fecha_venta, estado, ciudad_id) VALUES
('Cemento', 'Cemento gris 50kg', 'Construcción', 25000.00, CURRENT_DATE - INTERVAL '8 months', CURRENT_DATE - INTERVAL '2 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C001')),
('Arena', 'Arena fina lavada', 'Construcción', 18000.00, CURRENT_DATE - INTERVAL '10 months', CURRENT_DATE - INTERVAL '1 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C005')),
('Grava', 'Grava triturada', 'Construcción', 22000.00, CURRENT_DATE - INTERVAL '6 months', CURRENT_DATE - INTERVAL '3 months', 'Vendido', (SELECT id FROM ciudad WHERE codigo='C009')),
('Acero', 'Varilla corrugada', 'Construcción', 55000.00, CURRENT_DATE - INTERVAL '7 months', CURRENT_DATE - INTERVAL '4 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C013')),
('Ladrillo', 'Ladrillo tolete', 'Construcción', 400.00, CURRENT_DATE - INTERVAL '12 months', CURRENT_DATE - INTERVAL '6 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C017')),

('Madera', 'Madera pino seca', 'Carpintería', 15000.00, CURRENT_DATE - INTERVAL '9 months', CURRENT_DATE - INTERVAL '5 months', 'Vendido', (SELECT id FROM ciudad WHERE codigo='C002')),
('Pintura', 'Pintura blanca 1 galón', 'Acabados', 35000.00, CURRENT_DATE - INTERVAL '5 months', CURRENT_DATE - INTERVAL '1 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C006')),
('Yeso', 'Yeso para construcción', 'Acabados', 12000.00, CURRENT_DATE - INTERVAL '4 months', CURRENT_DATE - INTERVAL '15 days', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C010')),
('Cerámica', 'Cerámica blanca 60x60', 'Acabados', 60000.00, CURRENT_DATE - INTERVAL '11 months', CURRENT_DATE - INTERVAL '3 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C014')),
('Teja', 'Teja de barro', 'Cubierta', 15000.00, CURRENT_DATE - INTERVAL '7 months', CURRENT_DATE - INTERVAL '2 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C018')),

('Vidrio', 'Vidrio templado 4mm', 'Acabados', 80000.00, CURRENT_DATE - INTERVAL '8 months', CURRENT_DATE - INTERVAL '1 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C003')),
('Pegante', 'Pegante cerámico 25kg', 'Construcción', 25000.00, CURRENT_DATE - INTERVAL '9 months', CURRENT_DATE - INTERVAL '2 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C007')),
('Cable', 'Cable eléctrico 10m', 'Eléctrico', 45000.00, CURRENT_DATE - INTERVAL '6 months', CURRENT_DATE - INTERVAL '1 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C011')),
('Tubería', 'Tubería PVC 4"', 'Hidráulico', 18000.00, CURRENT_DATE - INTERVAL '10 months', CURRENT_DATE - INTERVAL '4 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C015')),
('Puerta', 'Puerta metálica reforzada', 'Carpintería', 120000.00, CURRENT_DATE - INTERVAL '12 months', CURRENT_DATE - INTERVAL '2 months', 'Disponible', (SELECT id FROM ciudad WHERE codigo='C019'));


