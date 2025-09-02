# Etapa de build
FROM node:18 as build
WORKDIR /app
COPY package*.json ./
RUN npm ci --legacy-peer-deps
COPY . .
RUN npm run build

# Etapa de servidor
FROM nginx:alpine
COPY --from=build /app/dist/materials-front /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

