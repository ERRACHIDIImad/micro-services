FROM  node:20.13.1-alpine3.20  as build

WORKDIR /app/

COPY package.json /app/
RUN npm install

COPY . /app/
RUN  npm run build

FROM nginx:alpine
COPY --from=build /app/dist/front-ang-end  /usr/share/nginx/html

